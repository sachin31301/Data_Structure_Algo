#include <bits/stdc++.h>

#define ll long long


#define adid emplace_back
#define ALL(x) begin(x), end(x)
#define RALL(x) rbegin(x), rend(x)
#define fastIO() ios_base::sync_with_stdio(0), cin.tie(0)

mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());



template<typename T1, typename T2>
ostream& operator << (ostream &os, pair<T1, T2> p) {
    os << "(" << p.first << "," << p.second << ")";
    return os;
}

template<typename T>
ostream& operator << (ostream &os, vector<T> vec) {
    for (int i = 0; i < vec.size(); ++i) {
        if (i) os << " ";
        os << vec[i];
    }
    return os;
}



#define f(i,a,b) for(int i=a;i<b;i++)


#define mod 1000000007


//#define mod 998244353

#define mp make pair


#define uniq(v) (v).erase (unique (all(v)), (v).end())


#define ff first


#define ss second


#define rf(i, a,b) for(int i=a;i>=b;i--)


#define sc(a) scanf("%lld",&a)

#define pf printf 24


#define sz(a) (int)(a.size())


#define psf push front


#define ppf pop_front


#define ppb pop_back


#define pb push_back


#define pq priority_queue


#define all(s) s.begin(),s.end()


#define sp(a) setprecision(a)

#define rz resize


#define ld long double

#define inf (11)1e18


#define eb emplace_back


const double pi= acos(-1);

using namespace std;
ll solution;
vector<vector<ll>>v;

vector<ll>myarray,sumer;

void dfs(int cur,int par)

{

 myarray[cur]=1,sumer[cur]=0;

ll cnt=0;

f(i,0,sz(v[cur]))

{

 ll node=v[cur][i];

if(node!=par)
 {

 dfs(node,cur);

myarray[cur]+=((2* (myarray[node]%mod))%mod), myarray[cur]%=mod, cnt++, cnt%=mod ,sumer[cur]+=sumer [node], sumer[cur]%=mod;

 }

 }

myarray[cur]-=cnt,myarray [cur]+=mod, myarray[cur]%=mod, sumer[cur]+=myarray[cur], sumer[cur]%=mod; solution+=myarray[cur], solution%=mod;

ll val=0,rem=(myarray[cur]-1+mod)%mod;

f(i,0,sz(v[cur]))

{
 int node=v[cur][i];

if(node!=par)

 {

 rem-=sumer[node], rem+=mod, rem%=mod;

val+=((((2*rem)%mod)*(sumer[node]%mod ) ) %mod), val%=mod;

 }

}

solution+=val;

solution%=mod;

}

int main() {

int z=1;

cin>>z;

f(i,1,z+1)

{

 solution=0;
int myvalue;

cin>>myvalue;

v.rz(myvalue+1),myarray.rz(myvalue+1),sumer.rz(myvalue+1);

f(i,0,myvalue-1)

{

 int l,r;

 cin>>l>>r;

 v[l].pb(r),v[r].pb(l);

}

 dfs(1,1);

cout<<solution%mod<<endl;
myarray.clear();

 v.clear();

sumer.clear();

}

 return 0;

}