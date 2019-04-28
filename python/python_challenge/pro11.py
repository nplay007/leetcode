from PIL import Image

image = Image.open("cave.jpg")
odd = even = Image.new(image.mode,[image.size[0]/2,image.size[1]])

for x in range(image.size[0]):
	for y in range(image.size[1]):
		if x % 2 == 0 and y % 2 == 0:
			even.putpixel((x / 2, y / 2), image.getpixel((x, y)))
		elif x % 2 == 0 and y % 2 == 1:
			odd.putpixel((x / 2, (y - 1) / 2), image.getpixel((x, y)))
		elif x % 2 == 1 and y % 2 == 0:
			even.putpixel(((x - 1) / 2, y / 2), image.getpixel((x, y)))
		else:
			odd.putpixel(((x - 1) / 2, (y - 1) / 2), image.getpixel((x, y)))
even.save("even.jpg")
odd.save("odd.jpg")