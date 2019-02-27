# Kevin and Stuart want to play the 'The Minion Game'.
#
# Game Rules:
# Both players are given the same string,
# Both players have to make substrings using the letters of the string
#
# Stuart has to make words starting with consonants.
# Kevin has to make words starting with vowels.
# The game ends when both players have made all possible substrings.
#
# Scoring
# A player gets +1 point for each occurrence of the substring in the string
#
# For Example:
# String
# = BANANA
# Kevin's vowel beginning word = ANA
# Here, ANA occurs twice in BANANA. Hence, Kevin will get 2 Points.
#
# Input Format: A single line of input containing the string
#
# Output Format: Print one line: the name of the winner and their score
#                separated by a space. If the game is a draw, print Draw.
#
# Sample Input: BANANA
#
# Sample Output:  Stuart 12

def minion_game(string):
    # your code goes here
    vowels = ['A', 'E', 'I', 'O', 'U']
    stuart_score = 0
    kevin_score = 0
    string_length = len(string)

    # This solves test cases 0, 1, 2, 3, 7, 9, and 11; however, test cases 4, 5,
    # 6, 8, 10, 12, 13, and 14 terminate due to timeout. See
    # "Minion_Game_Test_Case_12.txt" to see just how long the test "word" is.
    # (p.s., it's 1,000,000 characters) 
    # while i < len(string) + 1:
    #     while j < len(string) + 1:
    #         if len(string[i:j]) > 0:
    #             # print(string[i:j])
    #             if string[i] in vowels:
    #                 kevin_score += 1
    #             else:
    #                 stuart_score += 1
    #         j += 1
    #     i += 1
    #     j = i

    # Here's an intuitive approach to solve the timeout issue: If we look at
    # "Minion_Game_Scoring_Example.png", Stuart will earn points from substrings
    # beginning with 'B' six times (B, BA, BAN, BANA, BANAN, BANANA). It's no
    # coincidence that's also the length of the full string. Similarly, Kevin
    # will earn points from the following substrings (A 3x, AN 2x, ANA 2x,
    # ANAN x1, ANANA x1). Thus, if we simply increment Kevin's score and
    # Stuart's score by the length of 'string', 
    # SIGNIFICANTLY cut down runtime, we will 
    for i in range(string_length):
        if string[i] in vowels:
            # print("Kevin", string[i], (len(string) - i))
            kevin_score += (string_length - i)
        else:
            # print("Stuart", string[i], (len(string) - i))
            stuart_score += (string_length - i)


    if stuart_score > kevin_score:
        print("Stuart", stuart_score)
    elif kevin_score > stuart_score:
        print("Kevin", kevin_score)
    else:
        print("Draw")

if __name__ == '__main__':
    s = input()
    minion_game(s)