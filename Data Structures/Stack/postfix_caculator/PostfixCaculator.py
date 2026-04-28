def Calculator(s) -> int:
    copy = str(s)
    list = copy.split(" ")
    
    operators = ('+', '-', '*', '/', '^')
    
    stack = []
    
    for token in list:
        if token in operators:
            temp_2 = stack.pop()
            temp_1 = stack.pop()
            
            result = 0
            
            if token == '/':
                assert temp_2 != 0, "can not divide by zero!"
            
            results = {'+': (temp_1 + temp_2), '-': (temp_1 - temp_2),
                       '*': (temp_1 * temp_2), '/': (temp_1 / temp_2),
                       '^': (temp_1 ** temp_2)}
            
            result = results[token]
            
            stack.append(result)
            
        else:
            stack.append(int(token))
            
    out = stack.pop()
    
    return out
