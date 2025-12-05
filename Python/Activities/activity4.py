print("Rock-Paper-Scissors Game")

while True:
    p1 = input("Player 1: ").lower()
    p2 = input("Player 2: ").lower()

    if p1 == p2:
        print("Tie!")
    elif (p1 == "rock" and p2 == "scissors") or \
         (p1 == "scissors" and p2 == "paper") or \
         (p1 == "paper" and p2 == "rock"):
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")

    again = input("Play again? (Yes/No): ").lower()

    if again == "no":
        print("Game Over!")
        break
