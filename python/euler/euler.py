import math 


def fibonacci_n(n):
    """fibonacci generator for number below n"""
    a, b = 0, 1
    while b < n:
        yield b
        a, b = b, a + b


def fibonacci():
    """
    fibonacci generator without limit
    """
    a,b = 0,1
    while True:
        yield b
        a, b = b, a + b


def prime_factors(n):
    """Generate all prime factors of n."""
    i = 2
    while i * i <= n:
        while n % i == 0:
            yield i
            n //= i
        i += 1
    if n > 1:
        yield n

def prime_factors_num(n):
    """count prime factors of n."""
    num = set()
    for item in prime_factors(n):
        num.add(item)
    return len(num)

def pythagorean(n):
    """
    generate pythagorean triplet(a,b,c)
    """
    for a in range(1, n + 1):
        for b in range(a + 1, n + 1):
            c = int(a ** 2 + b ** 2) ** 0.5
            if c <= n and a ** 2 + b ** 2 == c ** 2:
                yield(a, b, c)

def isprime(number):
    """judge a number is a prime or not"""
    if number < 2:
        return False
    if number == 2:
        return True
    else:
        if number % 2 == 0:
            return False
        for current in range(3, int(math.sqrt(number)+1), 2):
            if number % current == 0:
                return False
    return True 


def prime_sieve(n):
    """Sieve of Eratosthenes
    Return a list of all primes less than n
    """
    l = range(n)
    l[1] = 0
    for i in range(2, int(math.sqrt(n)) + 1):
        if l[i]:
            l[i**2::i] = [0] * ((n - 1 - i**2)//i + 1)
    return [x for x in l if x]

def generate_prime():
    """
    generate prime number with no limit
    """
    def hex_step():
        num = 1
        while True:
            hex_num = 6 * num
            yield hex_num - 1
            yield hex_num + 1
            num += 1

    def is_prime(num):
        for p in primes:
            if num % p == 0:
                return False
            if p**2 > num:
                return True
    yield 2
    yield 3
    primes = [3]
    for n in hex_step():
        if is_prime(n):
            yield n
            primes.append(n)


def ispalidromes(strnum):
    return strnum == strnum[::-1]

def is_factorials(num):
    data = map(int,str(num))
    sumdata = 0
    for item in data:
        sumdata += math.factorial(item)
    return num == sumdata
