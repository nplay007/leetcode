def calcEquation(self, equations, values, queries):
    quote = collections.defaultdict(dict)
    for (num, den), val in zip(equations, values):
        quote[num][num] = quote[den][den] = 1.0
        quote[num][den] = val
        quote[den][num] = 1 / val
    for k in quote:
        for i in quote[k]:
            for j in quote[k]:
                quote[i][j] = quote[i][k] * quote[k][j]
    return [quote[num].get(den, -1.0) for num, den in queries]