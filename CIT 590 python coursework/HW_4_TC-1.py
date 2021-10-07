# Name: Thomas Clement
# Penn ID: 21828132
# I, Thomas Clement, worked on this assignment alone and did not collaborate.



import random

# Required Functions section
def setup_bricks():
    '''
     The function accomplishes the following:
    (1) Creates a pile of 60 bricks represented as a list containing the integers between 1-60.
    (2) The function also creates an discared pile, which is represented as an empty list.

    The function then returns both (1) & (2) as tuples, rather than lists
    '''

    # The function creates the required lists
    main_pile = []
    discard_pile = []

    # Loop to generate the main pile with values 1-60
    for i in range(1, 61):
        main_pile.append(i)
    return (main_pile, discard_pile)


def shuffle_bricks(bricks):
    '''
    This function shuffles the bricks, represented as a list and returns nothing
    '''
    random.shuffle(bricks)


def check_bricks(main_pile, discard):
    '''
    This fucntion:
    Checks to see if there are any cards remaining in the main pile,
    If there are no cards remaining then the discarded pile is shuffled and those bricks are then moved to
    The main_pile.

    Once the main_pile has been populated with shuffled cards the function then takes the top card and places
    at the top of the discard pile.
    '''
    # the function checks to see if the 'main_pile' is empty and provided it is empty:
    if len(main_pile) == 0:
        # shuffles the discard pile
        shuffle_bricks(discard)
        # Sets a variable used to control the flow of the function
        flow = True
        # This block will loop through the discard list poping each value and appending it to the
        # 'main_pile' list
        while discard:
            current = discard.pop(0)
            main_pile.append(current)
        # This block will only be entered once, here the top card of the discard pile is poped and then
        # appended to the discard pile which is empty.
        while flow:
            current = main_pile.pop(0)
            discard.append(current)
            flow = False


def check_tower_blaster(tower):
    '''
    This Function determines if a given player's tower is stable.
    If a given players tower is stable then the program returns True else False.
    '''
    # creates an empty list
    results = []
    # This loop will iterate over the tower parameter and check to ensure that the current entry in the
    # tower is less than the next brick in the given tower. This logical output is then stored in 'x' and
    # appended to result
    for i in range(len(tower) - 1):
        x = tower[i] <= tower[i+1]
        results.append(x)
    # This if/else block will return false if there is a false entry in results and true otherwise.
    if False in results:
        return False
    else:
        return True


def get_top_brick(brick_pile):
    '''
    This function will remove and return the top bloakc having index number of 0 from the
    given 'brick_pile'
    '''
    top_brick = brick_pile.pop(0)
    return top_brick


def deal_initial_bricks(main_pile):
    '''
    This function takes a list 'main_pile' as an input. The function then creates two
    lists one for the computer and then one for the user. The function then populates each
    of these with the index 0 value from the pain pile and then appends each of the users
    lists to contain this value.
    The function will then return the 'users_brick' list & the 'comp_bricks' list.
    '''
    # The function creates the required lists
    user_bricks = []
    comp_bricks = []
    # The following loop will be iterated over 10 times:
    # (1) the top brick is stored in a variable 'y'
    # (2) this 'y' value is then appended to the computer's tower
    # (3) The next brick on the top of the main_pile is then stored in the variable 'x'
    # (4) This 'X' value is then appened to the user's tower
    # This is done ten times, so each users tower will have ten bricks in it.
    for i in range(10):
        y = main_pile.pop(0)
        comp_bricks.append(y)
        x = main_pile.pop(0)
        user_bricks.append(x)
    return (user_bricks, comp_bricks)


def add_brick_to_discard(brick, discard):
    '''
    This function will take the given 'brick' that is passed to the function and
    will add it to the discard pile. The first parameter of the function ought to be
    an integer and the second parameter of the function ought to be a list.
    '''
    discard.insert(0, brick)


def find_and_replace(new_brick, brick_to_be_replaced, tower, discard):
    '''
    This function takes two integers as inputs. The function then checks to ensure that
    the 'brick_to_be_replaced' is in a given users tower.
    Subsequent to having checked if the 'brick_to_be_replaced' is
    '''
    # The function checks if the brick to be replaced is in the tower
    if brick_to_be_replaced in tower:
        # This loop will iterate over the length of the tower
        for i in range(len(tower)):
            # This if block checks if the brick to be replaces is equal to a given brick in the tower.
            # if True, the new brick will be inserted into the tower and the brick it replaced is placed
            # in the discard pile
            if tower[i] == brick_to_be_replaced:
                tower.insert(i, new_brick)
                tower.pop(i + 1)
                discard.insert(0, brick_to_be_replaced)
                return True
    # if the fucntion is not able to find the brick to be replaced the function will return False
    else:
        return False




def computer_play(tower, main_pile, discard):
    """
    The function responsible for the move made by the computer (that is the programmer's
    turn to change the tower is handled by this function.
    """
    # The top brick of the main pile is popped and stored as a variable
    brick = get_top_brick(main_pile)

    # If the brick is in [1:30], the tower will be look through the tower
    if brick in range(1, 31):
        # For the brick in range [1:15]
        if brick in range(1, 16):
            # the function will iterate over the computer's tower from [0:9]
            for i in range(10):
                # If a tower brick is found > than the brick, it will be replaced.
                if tower[i] > brick:
                    find_and_replace(brick, tower[i], tower, discard)

                    break
        # If the brick is not in the range [1:15]
        else:
            # the function will iterate over the computer's tower from [9:0]
            for i in range(9, -1, -1):
                # If a tower brick is found < than the brick, it will be replaced.
                if tower[i] < brick:
                    find_and_replace(brick, tower[i], tower, discard)
                    #
                    break
    # If the number is between [31:60], This else statement is entered.
    else:
        # if the brick is between [31:45]
        if brick in range(31, 46):
            # the function will iterate over the computer's tower from [0:9]
            for i in range(10):
                # If a tower brick is found > than the brick, it will be replaced.
                if tower[i] > brick:
                    find_and_replace(brick, tower[i], tower, discard)

                    break
        # if the brick is not between [31:45] the else: block is entered
        else:
            # the function will iterate over the computer's tower from [9:0]
            for i in range(9, -1, -1):
                # If a tower brick is found < than the brick, it will be replaced.
                if tower[i] < brick:
                    find_and_replace(brick, tower[i], tower, discard)
                    #
                    break
    return tower



def main():
    '''
    This is the main logic for the program. Calling this function will run the program: Tower Blaster.
    '''
    # Sets two lists as 'main_pile' & 'discard'
    (main_pile, discard) = setup_bricks()

    # this function shuffles the main pile of bricks
    shuffle_bricks(main_pile)

    # This line sets up two list as 'user_tower' & 'comp_tower' and uses the deal_initial_bricks
    # function to populate the lists
    (user_tower, comp_tower) = deal_initial_bricks(main_pile)

    # Creates an empty list called discard
    discard = []

    # This sets the variable that will later be called in the 'computer_play()' function = 0.
    # this variable functions as a counter so the 'computer_play()' function can tell how many times
    # it has been called
    counter = 0

    # This line prints the computer's initial tower to the user
    print('The computer\'s initial tower is:', comp_tower)
    # This while loop will be iterated over so long as neither players tower has stability
    while check_tower_blaster(user_tower) == False and check_tower_blaster(comp_tower) == False:
        # Checks to see that there are still bricks remaining in the main brick pile.
        check_bricks(main_pile, discard)
        # This function simulates the computer's turn in the game. It will return the computer's tower
        comp_tower = computer_play(comp_tower, main_pile, discard)

        # The following block of code prints all relevant information to the user
        print('\n')
        print('--- NOW IT\'S YOUR TURN! ---')
        print('\n')
        print('Your Tower:', user_tower)
        print('The top brick on the discard pile is', discard[0])
        print('Type \'D\' to take the discard brick, \'M\' for a mystery brick')
        # prompts the user for a response and stores it in a variable named 'action'
        action = True
        action = input('response: ')

        # This block of code is entered when the letter d is in the variable named 'action'.
        # When this block is entered:
        if action == 'D' or action == 'd':
        #if 'D' or 'd' in action:
            # (1) the 'get_top_brick()' function is called and its return is assigned to a variable
            # named brick
            brick = get_top_brick(discard)

            # (2) The following block of code is prints the user all important information.
            print('You picked', brick, 'from the discard pile.')
            print('\n')
            print('Do you want to use this brick? Type \'Y\' or \'N\' to skip turn')
            # (3) The user is prompted for a response.
            to_do = True
            to_do = input('response(Y/N): ')

            #if 'n' or 'N' in to_do:
            if to_do == 'n' or to_do == 'N':
                # If 'n' is in the user's response the program will add the current brick to the
                # discard pile
                add_brick_to_discard(brick, discard)
            if to_do == 'y' or to_do == 'Y':
                #elif 'Y' or 'y' in to_do:

                # If 'y' is in the user's response, the program will prompt the user for the index of the brick
                # The user will then be prompted for the for the index [1:10] of the brick in their dower that they
                # want to replace.

                # The loop also prints various statements depending on the output of the the call to
                # 'find_and_replace()'

                print('where do you want to place this brick? Type the index of the brick to replace in your tower. [1:10]')
                res = input('response: ')
                res = (int(res) - 1)
                x = find_and_replace(brick, user_tower[res], user_tower, discard)
                if x == True:
                    print('You successfully replaced a brick!')
                else:
                    print('Program is broken')

        # This block of code is entered when the letter 'm' is in the variable named 'action'.
        # When this block is entered:
        if action == 'M' or action == 'm':
            # (1) the 'get_top_brick()' function is called and its return is assigned to a variable
            # named brick
            brick = get_top_brick(main_pile)

            # (2) The following block of code is prints the user all important information.
            print('You picked', brick, 'from the main pile.')
            print('\n')
            # (3) The user is prompted for a response.
            to_do = True
            to_do = input('Do you want to use this brick? Type \'Y\' or \'N\' to skip turn')

            if to_do == 'n' or to_do == 'N':

                # For some reaosn using this statement caused errors
                #if 'N' or 'n' in to_do:

                # If 'n' is in the user's response the program will add the current brick to the
                # discard pile
                add_brick_to_discard(brick, discard)
            if to_do == 'y' or to_do == 'Y':
                #elif 'Y' or 'y' in to_do:

                # If 'y' is in the user's response, the program will prompt the user for the index of the brick
                # The user will then be prompted for the for the index [1:10] of the brick in their dower that they
                # want to replace.
                print('where do you want to place', brick, '? Type a brick number to replace in your tower [1:10].')
                res = input('response: ')
                res = (int(res) - 1)
                x = find_and_replace(brick, user_tower[res], user_tower, discard)
                if x == True:
                    print('You successfully replaced a brick!')
                else:
                    print('Program is broken')

    # The following two if() and elif() statements will both print different messages depending on which of the
    # two players have achiever tower stability. To learn more about the 'check_tower_blaster'
    # function:
    # Type :help(check_tower_blaster): into the python console
    if check_tower_blaster(comp_tower) == True:
        print('\n')
        print('*****  YOU HAVE LOST!!!!! ***** ')
        print('\n')
        print('The Final Results are: ')
        print(' Computer\'s tower:', comp_tower)
        print(' User\'s tower:', comp_tower)
        print('The Computer has won')
        print('\n')
        print('***** The Game is over ***** ')
        print(' Run the program again if you would like to play again!')

    elif check_tower_blaster(user_tower) == True:
        print('\n')
        print('--- Congratulations you have won the game ---')
        print('\n')
        print('The Final Results are: ')
        print(' Computer\'s tower:', comp_tower)
        print(' User\'s tower:', comp_tower)
        print('The User has won')
        print()
        print('WOOOHOOOOOOOO!!!!!!!!')
        print('\n')
        print('***** The Game is over ***** ')
        print(' Run the program again if you would like to play again!')

    while True:
        print('***** The Game is over ***** ')
        print(' Run the program again if you would like to play again!')
        res = input('enter \'exit\' to exit the program')
        if res.strip() == 'exit':
            break


if __name__ == '__main__':
    main()