import urllib2,pickle

url = "http://www.pythonchallenge.com/pc/def/banner.p"

f   = urllib2.urlopen(url)
obj = pickle.load(f)
f.close()

for item in obj:
    print "".join(i[0] * i[1] for i in item) #print characters

# we will get channel

