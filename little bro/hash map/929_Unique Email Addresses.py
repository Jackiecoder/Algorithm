class Solution(object):
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        res = set()
        for name in emails:
            locname, domname = name.split('@')
            beforePlus = locname.split('+')[0]
            noSpot = "".join(beforePlus.split('.'))
            realname = noSpot+'@'+domname
            # print(realname)
            res.add(realname)
        return len(res)