import sys
account_balance = float(500.25)
# print functions here
def print_balance():
  return account_balance
# make sure to set parameters i.e. amount
def deposit_amount(amount):
  return account_balance + amount
def withdrawal_amount(amount):
	return account_balance - amount
userchoice = input ("What would you like to do?\n")
if (userchoice == 'B'):
  print('Your current balance:')
  print(print_balance())
elif (userchoice == 'D'):
  deposit = float(input('How much would you like to deposit today?\n'))
  account_balance = deposit_amount(deposit) #pass values to the function
  print('Deposit was $%.2f, current balance is $%.2f'%(deposit,account_balance))
elif (userchoice == 'W'):
  withdrawal = float(input('How much would you like to withdraw today?\n'))    
  if withdrawal > account_balance:
    print('$%.2f is greater than your account balance of $%.2f'%(withdrawal,account_balance))
  else:
    account_balance = withdrawal_amount(withdrawal)
    print('Withdrawal amount was $%.2f, current balance is $%.2f'%(withdrawal,account_balance))
else:
  print('Thank you for banking with us.')
