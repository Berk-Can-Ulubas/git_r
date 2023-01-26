import random

def get_choices():
    player_choice = input("Enter a choice (rock, paper, scissors: ")
    options = ["rock", "paper", "scissor"]
    computer_choice = random.choice(options)
    choices = {"player": player_choice, "computer": computer_choice}
    return choices

def check_win(player, computer):
    print(f"You chose {player}.")
    print(f"Computer chose {computer}.")
    if player == computer:
        return "its a tie!"



check_win("rock", "rock")

#dict = {"name": "beau", "color": choices

#choices = get_choices()
#print(choices)


#def greeting():
#    return "Hi"

#response = greeting()
#print(response)


#food = ["pizza", "carrots", "eggs"]
#dinner = random.choice(food)

#a = 3
#b = 5 
#if a < b:
#    print("yes")