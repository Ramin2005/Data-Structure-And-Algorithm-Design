# f(s, sorted(dict, key=len, reverse=True))

def f(s, dict) -> str:
    if len(s) == 0:
        return ""
    s = str(s)
    word = ""
    for temp in dict:
        if s.lower().startswith(temp.lower()):
            word = temp
            break
    length = len(word)
    word = s[0: length]
    return (word + " " + f(s[length::], dict))

