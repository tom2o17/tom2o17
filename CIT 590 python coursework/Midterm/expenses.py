# Name: Thomas Clement
# Penn ID: 21828132
# I, Thomas Clement, worked on this assignment alone and did not collaborate.

def import_expenses(expenses, file):
    '''
    This function will read data from a designated file.
    These read values are then summed according to their expense_type and appended to a dictionary that exists
    outside of this function.

    If the text file reads:
        coffee: 5 \n, clothes 5 \n, coffee: 5 \n, clothes: \n
    calling the function on this file will result in the following dictionary:
        {coffee: 10, clothes: 5}

    This function does not return anything
    '''
    #file = 'expenses.txt'
    #file = 'expenses_2.txt'

    # Opens the file that is handed to the function, and stores it in a variable t.
    t = open(file)
    # The readlines function is then called on the item 't' and the result is then stored in the 'txt' variable.
    txt = t.readlines()
    # The file is closed
    t.close()

    # Empty lists are made
    types = []
    amounts = []
    lines = []
    # For each line in the 'txt' variable
    for line in txt:
        # if the text line is not blank
        if line != '\n':
            # The new line comment is cut from 'txt' line
            line = line.strip('\n')
            # All trailing leading or lagging spaces are cut
            line = line.strip()
            # This line is then appended to the list named 'lines'
            lines.append(line)

    # A new empty list is then initialized
    list = []
    # for Each of line of text in the 'lines' list i
    for i in range(len(lines)):
        # The given line is split at the ':' and the expense type is stored in 'x' and the value is stored in 'y'
        x, y = lines[i].split(':')
        # Both variables are then stripped
        x = x.strip()
        y = y.strip()

        # If the given line does not have a value following the colon
        if y == '':
            # The loop is broken and the entry is not appended to the list
            continue
        else:
            # The value is cast to a float
            y = float(y)
        # 'x' and 'y' are then packaged into a tuple
        values = (x, y)
        # 'x' is appended to the typed variable
        types.append(x)
        # 'y' is then appended to the amounts list
        amounts.append(y)
        # The tuple that was created earlier is then appended to 'list'
        list.append(values)

    # 'Keys' is the unique 'types' of the expenses that we have just read. There will be duplicate values
    # for coffee in the 'keys' variable
    keys = set(types)
    # An empty list is then created
    hold = []
    # For each unique 'type' in keys
    for value in keys:
        # An empty list is then initialized
        obs = []
        # For each entry in a vector that is the same
        for i in range(len(types)):
            # If the unique 'type' in keys is equal to any of the entrys in the list of types
            if value == types[i]:

                # The expense value corresponding to 'type' is then stored as 'y'
                 y = amounts[i]
                # This is then cast to a float just because
                 y = float(y)
                # This value is then appended to the 'obs' list
                 obs.append(y)

        # The total value for all values of a given 'type' in keys is then calculated
        result = sum(obs)
        # The unique 'type' and total expense value is then stored in a tuple
        name = (value, result)
        # This tuple is then appended to the hold list
        hold.append(name)

    # This list of tuples that contain the unique total values from the file is then cast into a dictionary
    d = dict(hold)

    # if the dictionary 'expenses' is empty
    if len(expenses) == 0:
        # the new dictionary is then inserted into the empty 'expenses' dictionary
        expenses.update(d)
    # Else if the 'expenses' dictionary is not empty
    else:
        # For each 'unique' type in the file
        for item in keys:
            # For each value in a copy of the current (populated) dictionary keys
            for value in expenses.copy().keys():
                # if the unique 'types' from the given file is one of the entries in the key to
                # the 'expenses' dictionary
                if value == item:
                    # The corresponding cost is then updated with the entry in the hold dictionary and
                    # that entry is then updated in the dictionary
                    expenses[value] = d[value] + expenses[value]

                # Else (converse) a new entry is made to the expenses dictionary
                elif item not in expenses.copy().keys():
                    expenses[item] = d[item]



def get_expense(expenses, expense_type):
    '''
    This function takes the 'expenses' dictionary as an input as well as 'expense_type'.
    The function will then check to see if the expense_type is already present in the dictionary:

    provided that the expense_type exists in the expenses dictionary the function will return the value
    corresponding to that expense type

    if the 'expense_type' is not present in the dictionary then the function will print a friendly message to the
    user and will return 'None'
    '''
    if expense_type in expenses.keys():
        result = expenses[expense_type]
    else:
        result = None
        print('The \'expense_type\' that you selected does not exist!')
    return result


def add_expense(expenses, expense_type, value):
    '''
    This function take 3 input parameters defined above.

    The function will check to ensure that 'expense_type' is present in the 'expenses' dictionary.

    provided the above ^ is true: the function will add the 'value' to the corresponding 'expense_type' in the
    'expenses' dictionary and print a message to the user

    if the 'expense_type' is not in the current 'expenses' dictionary.
        A new entry is created with the corresponding 'expense_type' and 'value' parameters that were handed
        to the function.

    This function does not return anything
    '''
    if expense_type in expenses.keys():
        expenses[expense_type] += value
        print('Expense type:', expense_type, '| cost:', value, 'dollars, has been added to the expense dictionary')
        print('The total expense value is', expenses[expense_type])
    else:
        expenses[expense_type] = value
        print('Expense type:', expense_type, '| cost:', value, 'dollars, has been added to the expense dictionary')
        print('The total expense value is', expenses[expense_type])



def deduct_expense(expenses, expense_type, value):
    '''
    This function takes three input parameters

    The function will check to ensure that 'expense_type' is present in the 'expenses' dictionary and
    check to see if the value that the user wishes to deduct is in fact less than the corresponding cost
    associated with the specified 'expense_type'.

    Provided the above condition ^ is satisfied then the function will deduct the 'value' parameter from the
    dictionary entry corresponding to that 'expense_type'

    else the function will print the user a friendly message and raise a RuntimeError
    '''
    if expense_type in expenses.keys():
        amt = expenses[expense_type]
        if value > amt:
            print('You have elected to deduct more than the current expense!')
            raise RuntimeError
        else:
            expenses[expense_type] -= value
    else:
        print('This \'expense_type\' you selected does not exist!')
        raise RuntimeError


def update_expense(expenses, expense_type, value):
    '''
    This function will update the expense for a given expense type.

    If: the 'expense_type' is present in the keys for the expense dictionary.
        Then: The cost associated with that expense type is then updated with the 'value' parameter
              given to the function
    else: If the expense type does not exist then a message is printed to the user.

    '''
    if expense_type in expenses.keys():
        expenses[expense_type] = value
        print(expense_type, value)
    else:
        print('This \'expense_type\' you selected does not exist!')



def sort_expenses(expenses, sorting):
    '''
    This function takes two input parameters and will return a list of tuples in the sort order that is specified
    by the 'sorting' function parameter.
    '''
    # An empty list
    result = []
    # if the 'sorting' input is 'expense_type'
    if sorting == 'expense_type':
        # For each entry in the keys dictionary
        for value in expenses.keys():
            # the amount is stored as:
            x = expenses[value]
            # The key name for whatever it is stored:
            y = value
            # These values are then stored as a tuple
            name = (y, x)
            # They are then appended to a list
            result.append(name)
        # That list is then sorted according to the first item in the tuple (so alphabetically .....)
        result.sort()
    # If the input designates that we should sort by amount:
    # the loop does the exact same thing as the previous loop but
    # the amount is in the first part of the tuple so it sorts according to largest value .
    # sorts according to the most expensive one
    elif sorting == 'amount':
        exp = []
        for value in expenses.keys():
            x = expenses[value]
            y = value
            #print(y,x)
            name = (x, y)
            exp.append(name)
        exp.sort(reverse = True)
        for i in range(len(exp)):
            value = exp[i][0]
            type = exp[i][1]
            hold = (type, value)
            result.append(hold)
    return result


def export_expenses(expenses, expense_types, file):
    '''
    This function takes three input parameters: 'expenses' = dictionary, 'expense_type' = str/list, and 'file'

    The function will then create an empty list and will then populate this list with a string.

    This string will contain the 'expense_type' and the corresponding amount present in the dictionary

    Finally, this list of strings corresponding and their corresponding values in the dictionary will be written
    to a file that is specified by the 'file' function parameter
    '''

    exp_lst = []
    for value in expense_types:
        # goes through the list from expense types and checks to see if the entry exists in the dictionary
        if value in expenses.keys():
            #print(value)
            # The amount expense amount is then stored
            amt = expenses[value]
            # a str variable is then made
            x = value + ' : ' + str(amt) + '\n'
            # It is then appended to the list that was initialized
            exp_lst.append(x)
        # else (if the expense type is not in the dictionary) the loop is continued
        else:
            continue

    # It is then all written to a file
    t = open(file, 'w')
    t.writelines(exp_lst)
    t.close()


def main():
    '''
    This is the main function for the program
    '''
    # dictionary is created
    expenses = {}

    # .txt files are imported
    import_expenses(expenses, 'expenses.txt')
    import_expenses(expenses, 'expenses_2.txt')

    # flow control variable
    ctrl = True

    # Welcome message why not
    print('Welcome to your Expense Management System')
    # infinite loop with one exit point
    while ctrl:
        # The user is give a menu of the choices he can make
        print('--- Enter 1 to get expense info.')
        print('--- Enter 2 to add an expense.')
        print('--- Enter 3 to deduct an expense.')
        print('--- Enter 4 to update an expense.')
        print('--- Enter 5 to sort expenses.')
        print('--- Enter 6 to export expenses.')
        print('--- Enter 0 to exit the system.')
        # The user is then prompted for their input
        action = input('Enter [0:6]')
        # input is stripped
        action = action.strip()
        # cast into an int
        action = int(action)

        # Depending on what the action is it will enter that block of code

        if action == 1:
            # user interface
            print('You have elected to get expense info.')
            print('What is the expense type you are looking for?')
            expense_type = input()
            # Gets the result from the 'expenses' dictionary
            result = get_expense(expenses, expense_type)
            # if the result does not return none that information is conveyed to the user
            if result != None:
                print('The expense value for', expense_type, 'is', result)

        elif action == 2:
            # user interface
            print('You have elected to add an expense.')
            print('What is the expense type you are looking for?')
            # Prompts user for input
            expense_type = input()
            print('What is the amount that you would like to add to this expense type?')
            # Prompts user for input
            value = input()
            # Cleaning up the input variables
            value = value.strip()
            value = float(value)
            # This then added using the add_expense function
            add_expense(expenses, expense_type, value)

        elif action == 3:
            # user interface
            print('You have elected to deduct an expense.')
            print('What is the expense type you are looking for?')
            expense_type = input()
            # Cleaning up the input variables
            expense_type = expense_type.strip()
            print('What is the amount that you would like to deduct to this expense type?')
            value = input()
            value = value.strip()
            value = float(value)
            # The deduct expense function is then called with the parameters specified by the user
            deduct_expense(expenses, expense_type, value)


        elif action == 4:
            # ..... You get the picture
            # ..... again its all just user interface and cleaning the input variable, but
            # plot twist we call the 'update_expense' function this time
            print('You have elected to update an expense.')
            print('What is the expense type you are trying to update?')
            expense_type = input()
            expense_type = expense_type.strip()
            print('What is the value that you would like to update this expense entry with?')
            value = input()
            value = value.strip()
            value = int(value)
            update_expense(expenses, expense_type, value)

        elif action == 5:
            # Same as comment block above but now we print the return from the call to the
            # 'sort_expense' function in a loop so that it looks nice.
            print('You have elected to sort your expenses.')
            print('What would you like to sort by?: \'expense_type\' or \'amount\'')
            sorting = input()
            sorting = sorting.strip()
            sorted_exp = sort_expenses(expenses, sorting)
            for i in range(len(sorted_exp)):
                print(sorted_exp[i])


        elif action == 6:
            # User interface
            print('You have elected to export your expenses.')
            print('What is a name for the file that you would like the program to write?')
            file = input()
            # flow control
            flow = True

            expense_types = []
            # infinite loop with one exit point and continuously prompts user for expense type,
            # which is then appended to the 'expense_types' list provided the user did not enter
            # 'N' into the prompt
            while flow:
                print('Please enter the expense type that you would like to export!')
                print('Enter \'N\' if you have entered in all the expense types you would like.')
                type = input()
                type = type.strip()
                if type != 'N':
                    expense_types.append(type)
                else:
                    flow = False

            # the export statement function is then called with the list that was created in the above
            # function
            export_expenses(expenses, expense_types, file)
            # A helpful message is then printed to the user.
            print('Your expenses have been exported!')

        # if the user elects to exit the program the flow control is set to false and the loop will stop
        elif action == 0:
            print('Thank you for using Thomas Clement\'s Expense Management System!')
            print('Have a good day!')
            ctrl = False
        # entered if the input is anything other than 1:6
        else:
            # This else statement will be entered if the user does not enter a value [1:6]
            print('The number you have selected is not an option!')
            print('Please select a different number!')


# The main function is then called
if __name__ == '__main__':
    main()