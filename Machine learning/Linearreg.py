import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


X=pd.read_csv('C:\DATA STRUCTURE & ALGO\Machine learning\Linear_X_Train.csv')
Y=pd.read_csv('C:\DATA STRUCTURE & ALGO\Machine learning\Linear_Y_Train.csv')
X = X.values
Y = Y.values

def hypothesis(x,theta):
    y=theta[0]+theta[1]*x

    return y

def gradient(X,Y,theta):
    m=X.shape[0]
    grad=np.zeros((2,))
    for i in range(m):
        x=X[i]
        ye=hypothesis(x,theta)
        y=Y[i]
        grad[0]+=(ye-y)
        grad[1]+=(ye-y)*x
    return grad/m

def graddescent(X,Y,maxsteps=100,learning_rate=0.1):
    theta=np.zeros((2,))
    for i in range(maxsteps):

        grad=gradient(X,Y,theta)
        theta[0]=theta[0]-learning_rate*grad[0]
        theta[1]=theta[1]-learning_rate*grad[1]
    
    return theta

theta= graddescent(X,Y)

ye=hypothesis(X,theta)
print(ye)