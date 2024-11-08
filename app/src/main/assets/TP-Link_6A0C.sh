# !/bin/bash
am start -n com.termux/com.termux.app.TermuxActivity
sleep 1
input text "sudo python3 OneShot/oneshot.py -i wlan0 --iface-down -b C0:C9:E3:25:6A:0C -p 82890919"
input keyevent 66