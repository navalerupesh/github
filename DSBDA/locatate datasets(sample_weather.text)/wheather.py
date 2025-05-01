import re

logs = """
2025-04-01 12:01:01 INFO Starting system...
2025-04-01 12:01:15 ERROR Disk space low!
2025-04-01 12:02:45 INFO System running normally
2025-04-01 12:03:00 ERROR Disk space low!
2025-04-01 12:03:30 WARNING CPU usage high
"""

pattern = r"(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}) (\w+) (.*)"

for line in logs.strip().splitlines():
    match = re.match(pattern, line)
    if match:
        timestamp, level, message = match.groups()
        print(f"Timestamp: {timestamp}, Level: {level}, Message: {message}")
