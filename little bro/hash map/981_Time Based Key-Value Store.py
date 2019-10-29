class TimeMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map = {}

    def set(self, key, value, timestamp):
        """
        :type key: str
        :type value: str
        :type timestamp: int
        :rtype: None
        """
        self.map[key] = self.map.get(key, {})
        self.map[key][timestamp] = value
        

    def get(self, key, timestamp):
        """
        :type key: str
        :type timestamp: int
        :rtype: str
        """
        dic = self.map
        if key not in dic:
            return
        if timestamp in dic[key]:
            return dic[key][timestamp]
        else:
            ts = [x for x in dic[key].keys() if x<timestamp]
            if len(ts) > 0:
                return dic[key][max(ts)]  
            return ""
