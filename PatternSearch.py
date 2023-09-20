import re

lorem_ipsum = '''Lorem ipsum dolor sit-amet, consectetur adipiscing elit. Phasellus iaculis velit ac nunc interdum tempor. 
Ut volutpat elit metus, vel auctor enim commodo at. Nunc quis quam non ligula ultricies luctus porta id justo. 
Quisque dapibus est ut sagittis bibendum. Mauris ullamcorper pellentesque porttitor. Ut sit:amet ex nec dolor gravida 
porttitor. Proin at justo finibus justo vestibulum congue. Suspendisse et ipsum et ipsum eleifend dapibus a fermentum 
lacus. Vivamus porta nunc eu nisl sagittis, quis vulputate metus dignissim. Integer non fermentum nisl, id vestibulum 
elit. Sed euismod vestibulum purus ut porttitor. Integer sit-amet mollis neque. Donec sed lacinia diam, ac finibus 
lectus. Mauris tempor ipsum nisl, vitae posuere est lacinia nec. Nam eget euismod odio.'''

# ^ would include everything BUT the following...
results = re.findall('[^A-Za-z0-9]', lorem_ipsum)
# print the number of occurrences 
print(len(results))
# [:-] would be both sit-amet and sit:amet
occurrences_sit_amet = re.findall('sit[-:]amet', lorem_ipsum)
print(len(occurrences_sit_amet))
# we are simply changing the findall to sit amet
occurrance_sit_amet = re.findall('sit amet', replace_results)
print(len(occurrance_sit_amet))