t = int(input())
for _ in range(t):
    k=int(input())
    n=int(input())

    a0 = [i for i in range(1,n+1)]

    for i in range(k):
        for j in range(1,n):
            a0[j]+=a0[j-1]
    print(a0[-1])