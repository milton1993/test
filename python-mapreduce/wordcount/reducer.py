__author__ = 'milton'

import sys

key_count = dict()
for line in sys.stdin:
    (key, val) = line.strip().split("\t")
    if key_count.has_key(key):
        key_count[key] = int(key_count[key]) + int(val)
    else:
        key_count[key] = int(val)
for (key1, value) in key_count.items():
    print "%s\t%s" % (key1, value)