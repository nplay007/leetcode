import zipfile,re

zf = zipfile.ZipFile("channel.zip","r")

num = 90052
comments = []

while True:
    try:
        num = int(re.findall('\d+',zf.read(str(num)+".txt"))[0])
    except:
        print zf.read(str(num)+".txt")
        break
    comments.append(zf.getinfo(str(num)+".txt").comment)

print "".join(comments)

comments = []
#collect the comments

for info in zf.infolist():
    comments.append(info.comment)

print "".join(comments)