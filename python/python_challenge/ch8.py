import re
from PIL import Image

f = Image.open("oxygen.png")
data = [f.getpixel((x,45)) for x in range(0,f.size[0],7)] # 7 is the implication on the picture,try to get the information at the gray line in the pic
value = [r for r,g,b,a in data if r==g==b]
print "".join(map(chr,map(int,re.findall("\d+","".join(map(chr,value))))))