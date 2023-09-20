import sys
'''
Section 1: Collect customer input
'''
#Use customer data
budget_charge = 40.00
daily_charge = 60.00
weekly_charge = 190.00
rentalPeriod = 5
#set your rental code and for what type of rental
rentalCode = input("(B)udget, (D)aily, or (W)eekly rental?\n")
rentalPeriod = int(input("Number of Days Rented:\n"))
#conditional statement for which type of rental
if rentalCode == 'D':
  baseCharge = rentalPeriod * daily_charge
#odoStart and end setup
odoStart = int(input("Starting Odometer Reading:\n"))
odoEnd = int(input("Ending Odometer Reading:\n")) 
#data for total miles
totalMiles = odoEnd-odoStart
#Find avg and extra mileage
averageDayMiles = totalMiles / rentalPeriod
extraMiles = 0
#conditional statement for avg mileage 
if averageDayMiles > 100:
  extraMiles = averageDayMiles - 100
mileCharge = extraMiles * 0.25
#make sure the amtDue is only 2 decimal points
amtDue = "%.2f" % (baseCharge + mileCharge)

#print the summary and make sure it's spaced properly
print('Rental Summary')
print('Rental Code:        ' + rentalCode)
print('Rental Period:        ' + str(rentalPeriod))
print('Starting Odometer:  ' + odoStart)
print('Ending Odometer:    ' + odoEnd)
print('Miles Driven:       ' + str(totalMiles))
print('Amount Due:         $' + amtDue)