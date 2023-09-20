
'''
The task is broken down into three sections.
Section 1 - User Input
Section 2 - loop through the grocery list
Section 3 - provide output to the console
'''
# create an empty bracket set for history
grocery_history = []
# 'c' = continue and 'q' = quit
question = 'c'
# create a while statement for when the question is not 'q'
while question != 'q':
  grocery_item = {}
  item_name = input('Item name:\n')
  quantity = input('Quantity purchased:\n')
  cost = input("Price per item:\n")
  grocery_item = {'name': item_name,'number': int(quantity),'price': float(cost)}
  grocery_history.append(grocery_item)
  question = input("Would you like to enter another item?\nType 'c' for continue or 'q' to quit:\n")
# set a value for grand_total
grand_total = 0
# create a for loop for each item in grocery_history
for grocery_item in grocery_history: 
  item_total = grocery_item['number'] * grocery_item['price']
  grand_total += item_total
  print("%d %s @ $ %.2f ea $%.2f" %(grocery_item['number'], grocery_item['name'], grocery_item['price'], item_total))  
# set item_total to 0
item_total = 0
# print grand total with header and $ 2 decimal places
print("Grand Total:$ %.2f" %(grand_total))