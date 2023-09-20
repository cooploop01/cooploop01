/*
 * Calculator.cpp
 *
 *  Date: 25 Mar 2021
 *  Author: Cooper Ring
 */

#include <iostream>

using namespace std;

void main() {
	char statement[100];
	int op1, op2;
	char operation;
	char answer = 'Y'; // = assigns the variable

	while (answer == 'Y' || answer == 'y') { // == compares the variable

		cout << "Enter expression" << endl;
		cin >> op2 >> operation >> op1; // input for operation

		if (operation == '+') { // == to compare so it doesn't print 4 operations
			cout << op1 << " + " << op2 << " = " << op1 + op2 << endl;
		}

		if (operation == '-') {
			cout << op1 << " - " << op2 << " = " << op1 - op2 << endl;
		}

		if (operation == '*') {
			cout << op1 << " * " << op2 << " = " << op1 * op2 << endl;
		}

		if (operation == '/') {
			cout << op1 << " / " << op2 << " = " << op1 / op2 << endl;
		}

		cout << "Do you wish to evaluate another expression? " << endl; // to make sure it asks after an operation is in/out
		cin >> answer; // y/Y or anything but
	}

	cout << "Program Finished" << endl; // anything but Y/y
	return; // ends the program


}
