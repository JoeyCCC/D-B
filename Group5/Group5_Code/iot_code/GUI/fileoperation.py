import os

# file operations
# get all files names in a selected directory.
def getFiles(dir):
    fileList=[]
    for item in os.listdir(dir):
        if os.path.isfile(os.path.join(os.path.abspath(dir),item)):
            fileList.append(item)
    return fileList

if __name__=="__main__":
    dir="model"
    print(getFiles(dir))