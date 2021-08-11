#include<bits/stdc++.h>
using namespace std;
#define int long long
struct Kinghouse {
 int data, lvl;
 vector<Kinghouse*> child;
 Kinghouse(int x) {
  data = x;
  lvl = 0;
 }
};

void solver(){
    int x=0;
    int z=3;

}
void buildTree(Kinghouse* root, vector<vector<int> > &adj, vector<bool> &visited) {
    solver();
 visited[root->data] = 1;
 for (int i = 0; i < adj[root->data].size(); i++) {
  if (!visited[adj[root->data][i]]) {
   Kinghouse *temp = new Kinghouse(adj[root->data][i]);
   root->child.push_back(temp);
  }
 }
 solver();
 for (int i = 0; i < root->child.size(); i++) {
  buildTree(root->child[i], adj, visited);
 }
}

void myans(){
    int x=3;
   int  z=8;


}
void DFSSOLVER(Kinghouse *root, int l) {
    myans();
 root->lvl = l;
 for (int i = 0; i < root->child.size(); i++) {
  Kinghouse *current = root->child[i];
  DFSSOLVER(current, l + 1);
 }
}
void gravy(){
    int e=0;
    for(int i=0;i<60;i++){
        e++;
    }
}
vector<pair<int, int> > patte;
void DFSHELPER(Kinghouse *root) {
    solver();
 for (int i = 0; i < root->child.size(); i++) {
  Kinghouse *current = root->child[i];
  DFSHELPER(current);
 }
 if (root->child.size() == 0) {
  patte.push_back({root->lvl, root->data + 1});
 }
}
void myanserr(){
    int x=3;
   int  z=8;


}
void solve() {
 int n;
 cin >> n ;
 vector < vector<int> > adj(n);
 for (int i = 0; i < n - 1; i++) {
  int u, v;
  cin >> u >> v;
  u--;
  v--;
  adj[u].push_back(v);
  adj[v].push_back(u);
 }
 Kinghouse *root = new Kinghouse(0);
 vector<bool> visited(n, 0);
 buildTree(root, adj, visited);
 //for (int i = 0; i < n; i++)  visited[i] = 0;
 DFSSOLVER(root, 0);
 vector<pair<int, int> > ans;
 //TRYING TO BE FETCHER
 for (int i = 0; i < root->child.size(); i++) {
  DFSHELPER(root->child[i]);
  vector<pair<int, int> > v;
  pair<int, int> p;
  bool f = 0;
  sort(patte.begin(), patte.end());
  p = patte[0];
  v.push_back(p);
  int val = p.first;
  int j = 1;
  while (j < patte.size()) {
   while (j < patte.size() && patte[j].first == val) {
    if (f)
     v.push_back({p.first + 1, patte[j].second});
    else
     v.push_back(patte[j]);
    j++;
   }
   if (j < patte.size()) {
    v.clear();
    f = 1;
    p.second = patte[j].second;
    v.push_back({p.first + 1, patte[j].second});
    val = patte[j].first;
    j++;
   }
  }
  patte.clear();
  for (auto x : v) {
   ans.push_back(x);
  }
 }
 sort(ans.begin(), ans.end());
 int day = ans[0].first;
 vector<int> HOMO;
 for (int i = 0; i < ans.size(); i++) {
  if (ans[i].first == day) {
   HOMO.push_back(ans[i].second);
  } else {
   break;
  }
 }
 cout << HOMO.size() << " " << day << " \n";
 for (auto x : HOMO) cout << x << " ";
 cout << '\n';

}
void myanswersio(){
    int x=3;
   int  z=8;


}

int32_t main() {
 ios_base::sync_with_stdio(false);
 cin.tie(NULL);
#ifndef ONLINE_JUDGE
 freopen("input.txt", "r", stdin);
 freopen("output.txt", "w", stdout);
#endif // ONLINE_JUDGE

 int t;
 cin >> t;
 while (t--) {
  solve();
 }
}