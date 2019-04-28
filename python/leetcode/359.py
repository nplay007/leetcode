class Logger(object):
    def __init__(self):
        self.log = {}

    def shouldPrintMessage(self, timestamp, message):
        if timestamp < self.log.get(message, 0):  # get the next printable timestamp
            return False
        self.log[message] = timestamp + 10  # set the next printable timestamp
        return True