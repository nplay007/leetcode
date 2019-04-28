from euler import prime_factors_num


num = 2*3*5*7
while True:
    if prime_factors_num(num) == 4:
        if prime_factors_num(num+1) == 4:
            if prime_factors_num(num+2) == 4:
                if prime_factors_num(num+3) == 4:
                    print num
                    break
    num += 1