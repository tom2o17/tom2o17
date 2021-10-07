# Name: Thomas Clement
# Penn ID: 21828132
# I, Thomas Clement, worked on this assignment alone and did not collaborate.

# import the random module
# use "gain = random.randint(0, 100)" to generate a random int from 0 - 100 and store in a variable "gain"
import random

# unit price of the soda
constant_soda_unit_price = 1

# unit price of the apple
constant_apple_unit_price = 5

# unit price of the lottery
constant_lottery_unit_price = 5

# unit price of the ps4
constant_ps4_unit_price = 200

# product number of soda
constant_soda_number = 1

# product number of apple
constant_apple_number = 2

# product number of lottery
constant_lottery_number = 3

# product number of ps4
constant_ps4_number = 4

constant_checkout_command = 5
# checkout command

is_shopping = True
while is_shopping:

    checkout = False

    # the user has initial $100 for shopping
    money = 100

    # the amounts of soda, apples, lotteries, ps4 the user has purchased in this round
    soda_amounts, apple_amounts, lottery_amounts, ps4_amounts = 0, 0, 0, 0

    # if user still has money and not check out yet
    while money > 0 and not checkout:

        # This statement prints the amount of money the user has
        print("\r\nMoney Available:", int(money), "dollar(s)")

        # This line of code prompts the user for the item that they wish to purchase
        x = input("What item do you want to buy [soda (1), apple (2), lottery ticket (3), ps4 (4) "
                  "or Check-out (5)]:")

        # This block of code casts the str input into an int value and catches Value errors
        try:
            x = int(x)
        except ValueError:
            print("Numerical Values only!")
            continue

        # These next lines of code test to make sure that the value that the user input is in the range
        # of acceptable values for our program
        if x < 1 or x > 5:
            print("No such item!")
            continue

        # This next block of code will set the random variable item and price to the correct values for the
        # item that the individual wishes to purchase. In the case where they select the check out option the
        # checkout variable is set to true
        if x == 1:
            item = "soda(s)"
            price = 1
        elif x == 2:
            item = "apple(s)"
            price = 5
        elif x == 3:
            item = "lottery ticket(s)"
            price = 5
        elif x == 4:
            item = "PS4(s)"
            price = 200
        elif x == 5:
            checkout = True

        # This portion of code will be utilized if the user enters a item #1-4. Setting the code up in this way
        # allows the user to bypass any questions regarding the quantity they wish to purchase if they select
        # the option to checkout
        if x >= 1 and x <= 4:
            z = input("\r\nHow much do you want to buy? : ")

            # This block will try to cast the amount the user wishes to buy into an int and will catch any value
            # errors in addition to not allowing the user to input a negative quantity
            try:
                amt = int(z)
            except ValueError:
                print("\r\nNumerical Values only!")
                continue
            if amt <= 0:
                print("\r\nYou must input a positive value number")
                continue

            # This portion of code will display to the user the amount of the item that they wish to purchase
            # and will also tell the user the total cost of their purchase.
            else:
                print("\r\nThe user wants to buy", amt, item)
                cost = price * amt
                print("This will cost", cost, "dollar(s)")

            # These three lines of code returns the user to the top of the second while loop if they do not
            # have enough money to make the purchase
            if money < cost:
                print("Not enough money!")
                continue

            # This block of code is entered if the user has enough money to purchase that quantity of that item
            # Line 121 will deduct the cost of the purchase from the users money value
            if money >= cost:
                money = money - cost

                # The following block will add the amount of the item purchased to the users inventory provided
                # that they have enough money
                if x == 1:
                    soda_amounts = soda_amounts + amt
                if x == 2:
                    apple_amounts = apple_amounts + amt



                # if the user selects to buy lottery tickets, this block of code will:
                # (1) set a variable for the money the user initially has after purchasing the lottery tickets,
                # this will be used at the end of the if: block in order to calculate how much money the user
                # gained by purchasing # of lotto tickets
                # (2) Prints the total money that the user has after all trips through the loop are completed

                # Within the for loop below:
                # (1) calculates the gain from the lottery ticket
                # (2) adds the monetary value gained from each lottery ticket to the users total money
                # (3) Prints a statement to the user telling them the value of each individual lottery ticket

                if x == 3:
                    money_int = money
                    lottery_amounts = lottery_amounts + amt
                    for number in range(0, amt):
                        gain = random.randint(0, 101)
                        money = money + gain
                        print("Your lottery ticket", number + 1, "had a", gain, "dollar(s) value!")
                    print("You earned a total of", money - money_int, "dollar(s) in the lottery")


                # This portion of code preforms the same function as lines 124-130
                if x == 4:
                    ps4_amounts = ps4_amounts + amt

        # This line of code ensures that if the user has no money after they make the purchase that they
        # will be prompted to check out
        if money == 0:
            checkout = True
        pass

    # This block of code is entered provided that the user has indicated that they want to checkout or if
    # the user has no money remaining after their most recent purchase
    if checkout == True:
        # This prints the contents of the users cart
        print("\nYou have decided to purchase:", "\n", soda_amounts, "soda(s)",
                  "\n", apple_amounts, "apple(s)", "\n", lottery_amounts, "lottery ticket(s)",
                  "\n", ps4_amounts, "Play Station(s)", "\n", "\n", "and you have", money, "dollar(s) left",
                  "\n")

        # This line asks the user if they would like to go shopping again, and then depending on their
        # response allows the user to either shop again or to stop shopping
        shop_again = input(" Do you want to go shopping again? (y/n): ")
        if shop_again == "n" or shop_again == "N":
            test = False
            print("\nThank you for shopping with us!\nPlease come again!")
            money = 0
            Checkout = True
            break
        if shop_again == "y" or shop_again == "Y":
            continue
