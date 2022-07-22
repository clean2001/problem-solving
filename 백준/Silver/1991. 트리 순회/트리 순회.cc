#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
struct Node {
    char data;
    Node* left;
    Node* right;
};

class binary_tree {
public:


    Node* root;
    vector<Node*> v;

    void insert_children(Node* cu, char ld, char rd) {
        if(ld != '.') {
            Node* left_c = (Node*)malloc(sizeof(Node));
            left_c->data = ld;
            left_c->left = left_c->right = NULL;
            cu->left = left_c;

            v.push_back(left_c);
        }
        if(rd != '.') {
            Node* right_c = (Node*)malloc(sizeof(Node));
            right_c->data = rd;
            right_c->left = right_c->right = NULL;
            cu->right = right_c;

            v.push_back(right_c);
        }

    }

    Node* find(char r) {
        for(Node* n : v) {
            if(n->data == r) return n;
        }

        return NULL;
    }

    void preorder(Node* current) {
        if(current == NULL) return;
        cout << current->data;
        preorder(current->left);
        preorder(current->right);
    }

    void inorder(Node* current) {
        if(current == NULL) return;
        inorder(current->left);
        cout << current->data;
        inorder(current->right);

    }

     void postorder(Node* current) {
        if(current == NULL) return;
        postorder(current->left);
        postorder(current->right);
        cout << current->data;
     }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    binary_tree t;
    t.root = (Node*)malloc(sizeof(Node));
    t.root->data = 'A';
    t.root->left = NULL;
    t.root->right = NULL;
    t.v.clear();
    t.v.push_back(t.root);

    for(int i=0; i<N; ++i) {
        char r;
        cin >> r;

        Node* current = t.find(r);
        char lv, rv;
        cin >> lv >> rv;
        t.insert_children(current, lv, rv);
    }

    t.preorder(t.root);
    cout << '\n';
    t.inorder(t.root);
    cout << '\n';
    t.postorder(t.root);
    cout << '\n';

    return 0;
}