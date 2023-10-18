import requests
import os
import time

# get video stream.(provided by Telecom members)
def save_image(response, save_dir, number):
    current_time = time.strftime("%Y%m%d%H%M%S", time.localtime())
    file_name = f"{current_time}_{number}.jpg"
    #save_path = os.path.join(save_dir, file_name)
    save_path=save_dir+"/"+file_name

    with open(save_path, 'wb') as file:
        for chunk in response.iter_content(1024):
            file.write(chunk)
    print("图片已保存:", save_path)

    return save_path


def startConn():
    save_dir = 'images'
    if not os.path.exists(save_dir):
        os.makedirs(save_dir)

    url = 'http://192.168.8.1:8083/?action=snapshot'
    number = 10

    for i in range(number):
        response = requests.get(url, stream=True)
        time.sleep(0.5)
        if response.status_code == 200:
            save_image(response, save_dir, i+1)
        else:
            print("获取图片失败")

if __name__ == '__main__':
    startConn()