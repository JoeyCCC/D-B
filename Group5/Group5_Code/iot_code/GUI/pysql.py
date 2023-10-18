import pymysql

# mysql connection problems
# mysql query problems
def sqlInput():
    db = pymysql.connect(host='10.29.2.179',
                         port=3306,
                         user='newuser',
                         password='Dajacky1',
                         database='javauser')

    cursor = db.cursor()

    print("Successfully connected with the databases")

    query = "insert into treasure(time,book,`cube`,`key`) values (%s,%s,%s,%s) "
    #query="delete from treasure where book=1"
    values=("202310101907",0,1,0)



    try:
        cursor.execute(query,values)
        db.commit()
        print("1 row affected")
    except:
        print("error!")

    cursor.close()
    db.close()

if __name__=="__main__":
    sqlInput()
