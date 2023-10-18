#include <Servo.h>
#include <SoftwareSerial.h>
// #define STOP      0
// #define FORWARD   1
// #define BACKWARD  2
// #define TURNLEFT  3
// #define TURNRIGHT 4
//定义迷宫算法需要变量
int N[20][20] = {0};
int dir = 3;//东南西北0123，初始方向设为北
int turn = 0;//前进0，后退2，左转3，右转1,初始化turn为0
int A[5][5];//随便设的一个数
int x0,y0;//起始位置
int x1,y1;//当前位置，初始与起始位置相同
int x[4] = {1,0,-1,0};//东南西北
int y[4] = {0,-1,0,1};
// 将蜂鸣器连接到Arduino的引脚2
const int buzzerPin = 2; 

// // 定义YL-99碰撞传感器连接的引脚
// const int collisionSensorPin = 3; 
// volatile bool collisionDetected = false;

//定义蓝牙模块
SoftwareSerial BT(14, 15);

//舵机引脚
int servopin = 9;
Servo myServo;
 
// 定义超声波模块的参数
const float speedOfSound = 0.034;
const int maxDistance = 200;
// 定义超声波引脚
const int trigPin1 = 41;
const int echoPin1 = 39;//前上
const int trigPin2 = 37 ;
const int echoPin2 = 36 ;//左
const int trigPin3 = 35 ;
const int echoPin3 = 34 ;//右
const int trigPin4 = 43 ;
const int echoPin4 = 42 ;//前下

float distance1;//得到四个方向距离
float distance2;
float distance3;
float distance4;
float distance_temp1 = 19;
float distance_temp2 = 25;
float distance_temp3 = 25;
float distance_treasure = 25;

int frequency = 0;
int color=0;
                
int count = 0;//记录宝藏数量
int temp[20][20] = {0};//负责记录宝藏位置以及拍摄情况

//小车各个轮子
int leftMotorF1 = 24;
int leftMotorF2 = 23;
int leftMotorB3 = 25;
int leftMotorB4 = 26;
int rightMotorF3 = 30;
int rightMotorF4 = 29;
int rightMotorB1 = 27;
int rightMotorB2 = 28;

//这块负责设置速度
int leftFPWM = 5;
int leftBPWM = 6;
int rightFPWM = 11;
int rightBPWM = 10;
int speed_forward = 85;


//手写栈
const int stackSize = 20; // define maximum volumn
int stack_x[stackSize]; // define all array as stack
int stack_y[stackSize];
int top_x = -1; // initialize top point of stack as -1,which indicates the stack is empty
int top_y = -1;
int value_x;
int value_y;

void setup() {
  Serial.begin(9600); // initialize series port
  initialize();
  digitalWrite(buzzerPin, HIGH);
  myServo.attach(9);
  BT.begin(9600);//Bluetooth
  x0 = 0;
  y0 = 0;
  x1 = x0;
  y1 = y0;
}
void loop() { 
  analogWrite(leftFPWM, speed_forward);
  analogWrite(leftBPWM, speed_forward); 
  analogWrite(rightFPWM, speed_forward);
  analogWrite(rightBPWM, speed_forward); 
  //start moving
  forward();
  printStack();

  distance1 = detect(trigPin1,echoPin1);//front-up
  Serial.print(" distance1 : ");
  Serial.println(distance1);
  distance4 = detect(trigPin4,echoPin4);//front-down
  Serial.print(" distance4 : ");
  Serial.println(distance4);
  if(distance1 <= distance_temp1 ){
  stop();
  delay(100);
  }
  treasure();//detecting treasure
  distance2 = detect(trigPin2,echoPin2);//left
  Serial.print(" distance2 : ");
  Serial.println(distance2);
  distance3 = detect(trigPin3,echoPin3);//right
  Serial.print(" distance3 : ");
  Serial.println(distance3);
  if(distance1 <= distance_temp1 && distance2 <= distance_temp2 && distance3 > distance_temp3 ){//there is obstacle on the left and front
    treasure();
    backward();
    turn = 1;//turn right
    dir = turnWhere(dir,turn);
    record(dir);
    Serial.println(" turn right1 ");
    rightTurn();
    printStack();
  }
  else if(distance1 <= distance_temp1 && distance2 > distance_temp2 && distance3 <= distance_temp3){//there is obstacle on the right and front
    treasure();
    backward(); 
    leftTurn();
    turn = 3;//turn left
    dir = turnWhere(dir,turn);
    record(dir);
    Serial.println(" turn left ");
    printStack();
  }
  else if(distance1 <= distance_temp1 && distance2 > distance_temp2 && distance3 > distance_temp3){//right-hand rule
    backward();
    treasure();
    rightTurn();
    turn = 1;//turn right
    dir = turnWhere(dir,turn);
    record(dir);
    Serial.println(" turn right2 ");
    printStack();
  }
  else if(distance1 <= distance_temp1 && distance2 <= distance_temp2 && distance3 <= distance_temp3){//dead end
    // stop();
    treasure();
    backward();
    rightTurn();
    turn = 1;//turn right
    dir = turnWhere(dir,turn);
    record(dir);
    Serial.println("turn right3");
    printStack();
 }
 else if(distance1 > distance_temp1 && distance2 > distance_temp2 && distance3 > distance_temp3){//cross-road
  forward();
  turn = 0;//forward
  printStack();
  Serial.println("forward");
  } 
  printStack();
}
//initailze
void initialize(){
  pinMode(trigPin1, OUTPUT);
  pinMode(echoPin1, INPUT);
  pinMode(trigPin2, OUTPUT);
  pinMode(echoPin2, INPUT);
  pinMode(trigPin3, OUTPUT);
  pinMode(echoPin3, INPUT);
  pinMode(trigPin4, OUTPUT);
  pinMode(echoPin4, INPUT);
  pinMode(buzzerPin, OUTPUT);

//  pinMode(collisionSensorPin, INPUT);

  pinMode(leftMotorF1, OUTPUT);
  pinMode(leftMotorF2, OUTPUT);
  pinMode(leftMotorB3, OUTPUT);
  pinMode(leftMotorB4, OUTPUT);
  pinMode(rightMotorB1, OUTPUT);
  pinMode(rightMotorB2, OUTPUT);
  pinMode(rightMotorF3, OUTPUT);
  pinMode(rightMotorF4, OUTPUT);
  pinMode(leftFPWM, OUTPUT);
  pinMode(leftBPWM, OUTPUT);
  pinMode(rightFPWM, OUTPUT);
  pinMode(rightBPWM, OUTPUT);
}
//ultrasonic sensor
float detect(int trigPin,int echoPin){

  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  long duration = pulseIn(echoPin, HIGH);
  float distance = duration / 58.0;
  return distance;
}
//record 
int turnWhere(int dir,int turn){
  dir=(dir+turn)%4;
  return dir;
}
//moving module
void forward(){
  analogWrite(leftFPWM, 85);
  analogWrite(leftBPWM, 85);
  analogWrite(rightFPWM, 85);
  analogWrite(rightBPWM, 85); 
  digitalWrite(leftMotorF1, HIGH);
  digitalWrite(leftMotorF2, LOW);
  digitalWrite(leftMotorB3, HIGH);
  digitalWrite(leftMotorB4, LOW);
  digitalWrite(rightMotorB1, HIGH);
  digitalWrite(rightMotorB2, LOW);
  digitalWrite(rightMotorF3, HIGH);
  digitalWrite(rightMotorF4, LOW);
}
void backward(){
  digitalWrite(leftMotorF1, LOW);
  digitalWrite(leftMotorF2, HIGH);
  digitalWrite(leftMotorB3, LOW);
  digitalWrite(leftMotorB4, HIGH);
  digitalWrite(rightMotorB1, LOW);
  digitalWrite(rightMotorB2, HIGH);
  digitalWrite(rightMotorF3, LOW);
  digitalWrite(rightMotorF4, HIGH
  );
  delay(20);
}
void leftTurn(){
  analogWrite(leftFPWM, 125);
  analogWrite(leftBPWM, 125);
  analogWrite(rightFPWM, 125);
  analogWrite(rightBPWM, 125); 
  digitalWrite(leftMotorF1, LOW); 
  digitalWrite(leftMotorF2, HIGH);
  digitalWrite(leftMotorB3, LOW);
  digitalWrite(leftMotorB4, HIGH);
  digitalWrite(rightMotorB1, HIGH);
  digitalWrite(rightMotorB2, LOW);
  digitalWrite(rightMotorF3, HIGH);
  digitalWrite(rightMotorF4, LOW);
  delay(600);
}
void rightTurn(){
  analogWrite(leftFPWM, 130);
  analogWrite(leftBPWM, 130);
  analogWrite(rightFPWM, 130);
  analogWrite(rightBPWM, 130); 
  digitalWrite(leftMotorF1, HIGH);
  digitalWrite(leftMotorF2, LOW);
  digitalWrite(leftMotorB3, HIGH);
  digitalWrite(leftMotorB4, LOW);
  digitalWrite(rightMotorB1, LOW);
  digitalWrite(rightMotorB2, HIGH);
  digitalWrite(rightMotorF3, LOW);
  digitalWrite(rightMotorF4, HIGH); 
  Serial.println("right!");
  delay(600);
}
void stop(){
  digitalWrite(leftMotorF1, LOW);
  digitalWrite(leftMotorF2, LOW);
  digitalWrite(leftMotorB3, LOW);
  digitalWrite(leftMotorB4, LOW);
  digitalWrite(rightMotorB1, LOW);
  digitalWrite(rightMotorB2, LOW);
  digitalWrite(rightMotorF3, LOW);
  digitalWrite(rightMotorF4, LOW);
  delay(10);
}
//find treasure
int readTre() {
  if(distance4 > 1 && distance4 < distance_temp1 ){
    if((distance1-distance4)>7){
      stop();
      delay(2000);
      Serial.println("stop1!");
      color = 1;  
    }
  }
  else{
    color = 0;
  }
  return color; 
}
void treasure(){
  if(count == 0){
    int Color = readTre();
    Serial.println(temp[x1][y1]);
    Serial.println(Color);
    if(Color == 1){
      count++;
      // temp[x1][y1] = 1;
      color = 0;
      Serial.println("find a treasure!");
     //stop and take a photo
      Serial.println("stop2!");
      servo();
      // count++;
    }
  }
}
// Bluetooth
void servo(){
  for (int pos=0;pos <= 180; pos +=1){
    myServo.write(pos);
    delay(100);//debug
  }
}
//buzzer sensor
void ring(){
  digitalWrite(buzzerPin, LOW); 
  delay(1000); 
  digitalWrite(buzzerPin, HIGH); 
  Serial.println("ring!");
}
void record(int dir){
  x1=x1+x[dir];
  y1=y1+y[dir];
  N[x1][y1]++;
  if(N[x1][y1]>1){ //>1，path repeat
    pop_x(value_x);
    pop_y(value_y);
    Serial.print("Popped value: ");
    Serial.print(value_x);
    Serial.print(" ");
    Serial.println(value_y);
  }
  else{
  push_x(x1);
  push_y(y1);
  Serial.print("Pushed value: ");
  Serial.print(x1);
  Serial.print(" ");
  Serial.println(y1);
  }
}


// 函数用于将元素入栈
void push_x(int value) {
    top_x++; // 栈顶指针上移
    stack_x[top_x] = value; 
}
void push_y(int value) {
    top_y++; // 栈顶指针上移
    stack_y[top_y] = value; 
}

// 函数用于从栈中出栈
void pop_x(int &value) {
    value = stack_x[top_x]; 
    top_x--; // 栈顶指针下移
}
void pop_y(int &value) {
    value = stack_y[top_y]; 
    top_y--; // 栈顶指针下移
}

void printStack() {
  // Serial.println("路线长度：");
  Serial.println(top_x);
  // Serial.println("路线经过的点：");

  for (int i = top_x ; i >= 0; i--) {
    Serial.print(top_x-i+1);
    Serial.print(" ");
    Serial.print(stack_x[i]);
    Serial.print(" ");
    Serial.println(stack_y[i]);
    BT.print(top_x-i+1);
    BT.print(" ");
    BT.print(stack_x[i]);
    BT.print(" ");
    BT.println(stack_y[i]);// output the path information
  }
}
//collision sensor
// void collision() {

//  int collisionSensorState = digitalRead(collisionSensorPin);//bug

//  if (collisionSensorState == HIGH) {//bug
//  forward();
//  } else {

//  stop();
//  Serial.println("collision happens,stop!");
//  }
// }
