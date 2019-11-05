import threading
import time
def sayhi(num):
    print("running on number",num,'\n')
    time.sleep(3)

if  "__main__" == __name__:
    start = time.time()
    lock = threading.Lock()
    t1 = threading.Thread(target=sayhi, args = [33])
    if lock.acquire:
        t1.start()
        lock.release
    print("T1 running time: ", time.time()-start)
    t1.join()
# print("good luck")