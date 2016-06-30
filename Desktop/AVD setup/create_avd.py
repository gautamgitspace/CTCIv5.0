#!/usr/bin/env python

import sys, os, argparse, subprocess, platform

def main():
  parser = argparse.ArgumentParser()
  parser.add_argument('number', help='number of AVDs you want to create',
      type=int)
  parser.add_argument('path', help='path to your Android SDK')
  parser.add_argument('-a', '--arch', help='the architecture (x86 or arm)',
      default='x86')

  args = parser.parse_args()
  arch = abi = args.arch
  path = args.path

  if arch == "arm":
    abi = "armeabi-v7a"
  elif arch != "x86":
    print "Supported architectures are x86 (default) or arm"
    return

  for i in range(args.number):
    n = str(i)
    cmd = "android create avd -n avd" + n + " -t android-19 -s QVGA -b "\
      + abi + " --force"
    print cmd
    if platform.system() == "Windows":
      p = subprocess.Popen(cmd.split(), stdin=subprocess.PIPE, shell=True)
    else:
      p = subprocess.Popen(cmd.split(), stdin=subprocess.PIPE)
    p.communicate(input='no\n')
    home = os.path.expanduser("~")
    avd_config = os.path.join(home, ".android", "avd", \
        "avd" + n + ".avd", "config.ini")
    if not os.path.exists(os.path.dirname(avd_config)):
      os.makedirs(os.path.dirname(avd_config))
    f = open(avd_config, "w")
    f.write("avd.ini.encoding=ISO-8859-1\n")
    f.write("hw.dPad=yes\n")
    f.write("hw.lcd.density=120\n")
    f.write("hw.cpu.arch=" + arch + "\n")
    f.write("hw.device.hash=1650583591\n")
    f.write("hw.device.hash2=MD5:20a2ae03a73ab2d9dd1f690c1f36a35c\n")
    f.write("hw.camera.back=none\n")
    f.write("disk.dataPartition.size=200M\n")
    f.write("skin.path=240x320\n")
    f.write("skin.dynamic=yes\n")
    if arch == "arm":
      f.write("hw.cpu.model=cortex-a8\n")
    f.write("hw.keyboard=yes\n")
    f.write("hw.ramSize=256\n")
    f.write("hw.device.manufacturer=Generic\n")
    f.write("hw.sdCard=no\n")
    f.write("hw.mainKeys=yes\n")
    f.write("hw.accelerometer=yes\n")
    f.write("skin.name=240x320\n")
    f.write("abi.type=" + abi + "\n")
    f.write("hw.trackBall=no\n")
    f.write("hw.device.name=2.7in QVGA\n")
    f.write("hw.battery=yes\n")
    f.write("hw.sensors.proximity=yes\n")
    image_path = 'system-images'
    android_version = 'android-19'
    if os.path.exists(os.path.join(path, image_path, android_version,
      'default')):
      f.write('image.sysdir.1=' + image_path + '/' + android_version + '/' +
        'default/' + abi + '/\n')
    else:
      f.write('image.sysdir.1=' + image_path + '/' + android_version + '/' + abi
        + '/\n')
    f.write("hw.sensors.orientation=yes\n")
    f.write("hw.audioInput=yes\n")
    f.write("hw.gps=yes\n")
    f.write("vm.heapSize=16\n")
    f.close()

if __name__ == "__main__":
  main()