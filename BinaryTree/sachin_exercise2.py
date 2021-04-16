import numpy as np
import random
import matplotlib.pyplot as plt
from scipy.stats import norm

my_list=np.random.randint(low = 1,high=20000,size=20000)

def divide_chunks(l, n):
          
    for i in range(0, len(l), n): 
        yield l[i:i + n]
  

n = 20000
  
x = list(divide_chunks(my_list, n))

a = np.array(x)
res = np.average(a, axis=0)
print(res[0:4])

def normal_dist(x , mean , sd):
    prob_density = (np.pi*sd) * np.exp(-0.5*((x-mean)/sd)**2)
    return prob_density

res.sort()
hmean = np.mean(res)
hstd = np.std(res)
pdf = normal_dist(res,hmean,hstd)
plt.plot(res,pdf , color = 'red')
plt.xlabel('Data points')
plt.ylabel('Probability Density')
plt.savefig('line_plot.pdf')
#plt.show(block=False)