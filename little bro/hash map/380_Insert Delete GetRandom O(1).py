class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.table = {}

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.table.keys():
            self.table[val] = 0
            return True
        return False
            
    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        temp = self.table.pop(val, None)
        if temp is None:
            return False
        return True

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        return random.choice(self.table.keys())

# redo the O(1)

class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.table = {}
        self.ls = []

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.table.keys():
            self.table[val] = len(self.ls)
            self.ls.append(val)
            return True
        return False
            
    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        ind = self.table.pop(val, None)
        if ind is None:
            return False
        key = self.ls.pop()
        if len(self.ls)!=0 and len(self.ls) != ind:
            self.ls[ind] = key
            self.table[key] = ind
        return True

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        return random.choice(self.ls)
