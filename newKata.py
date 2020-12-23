import shutil
import os
from pathlib import Path
import casestyle


kataPrefix = "/kata-"
templateName = "TEMPLATE"

def main():
    kataName = input("How would you like to call the kata: ")
    while not kataName:
        kataName = input("CONCENTRATE! How would you like to call the kata: ")

    # path
    path = os.getcwd()

    # Source path
    src = path+kataPrefix+templateName

    # Destination path
    dest = path+kataPrefix+casestyle.kebabcase(kataName)

    destination = shutil.copytree(src, dest)
    destinationPath = Path(destination)
    for file in destinationPath.rglob('*TEMPLATE*'):
        if (file.name.endswith(".java")):
            newName = file.name.replace("TEMPLATE",casestyle.pascalcase(kataName))
        elif (file.name.endswith(".gradle")):
            newName = file.name.replace("TEMPLATE",casestyle.kebabcase(kataName))
        newFile = str(file.parents[0])+"/"+newName
        os.rename(file,newFile)
        with open(newFile, 'r+') as f:
            content = f.read()
            f.seek(0)
            f.truncate()
            f.write(content.replace('TEMPLATE', casestyle.pascalcase(kataName)))

    # INSERT INTO settings.gradle
    f = open("settings.gradle", "r")
    contents = f.readlines()
    f.close()

    contents.insert(2, f"include '{destinationPath.name}'\n")

    f = open("settings.gradle", "w")
    contents = "".join(contents)
    f.write(contents)
    f.close()



if __name__ == '__main__':
    main()
