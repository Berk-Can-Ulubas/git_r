import random


def get_choices():
    player_choice = input("Enter a choice (rock, paper, scissors): ")
    options = ["rock", "paper", "scissors"]
    computer_choice = random.choice(options)
    choices = {"player": player_choice, "computer": computer_choice}
    return choices


def check_win(player, computer):
    print(f"You chose {player}.")
    print(f"Computer chose {computer}.")
    if player == computer:
        return "its a tie!"
    elif player == "rock":
        if computer == "sissors":
            return "Rock smashes scissors! You win!"
        else:
            return "Paper covers Rock! You lose."
    elif player == "paper":
        if computer == "rock":
            return "Paper covers Rock! You win!"
        else:
            return "Sissors cuts Paper! You lose."
    elif player == "scissors":
        if computer == "paper":
            return "Sissors cuts Paper! You win!"
            else:
            return "Rock smashes Scissors! You lose."


choices = get_choices()
result = check_win(choices["player"], choices["computer"])
print(result)

# dict = {"name": "beau", "color": choices}

# choices = get_choices()
# print(choices)


# def greeting():
#    return "Hi"

# response = greeting()
# print(response)


# food = ["pizza", "carrots", "eggs"]
# dinner = random.choice(food)

# a = 3
# b = 5
# if a < b:
#    print("yes")
'''
age = 20
if age >= 18:
    print("You are an abdult.")
elif age >12: 
    print("You are a teenager.")
elif age > 1:
    print("You are a child.")
else:
    print("You are a baby.")
'''
