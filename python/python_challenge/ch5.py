import urllib2 as ur
import re

link = "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing="
data = "44827"

while True:
    try:
        data = "".join(re.findall('\d+',ur.urlopen(link+data).read()))
    except:
        print data
