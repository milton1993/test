__author__ = 'milton'
import re
import sys

for line in sys.stdin:
    val = line.strip()
    words = val.split(" ")
    for word in words:
        print "%s\t%s" % (word, 1)