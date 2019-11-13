import random


class test_case(object):
    def __init__(self, n):
        self.testcase = list(range(n))

    def shuffle(self):
        random.seed(123)
        random.shuffle(self.testcase)
        return self.testcase
