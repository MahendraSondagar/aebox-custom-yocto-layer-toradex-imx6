#!/bin/bash

cd ..
mkdir oe-core
cd oe-core
repo init -u git://git.toradex.com/toradex-manifest.git -b kirkstone-6.x.y -m tdxref/default.xml
repo sync

#switch meta-openembedded to kirkstone branch
#cd layers/meta-openembedded
#git checkout kirkstone

#clone poky layer (kirkstone branch)
git clone -b kirkstone https://github.com/yoctoproject/poky.git layers/poky
#clone meta-qt6 (6.6.3 branch)
git clone -b 6.6.3 https://github.com/YoeDistro/meta-qt6.git layers/meta-qt6

#copy meta-aebox to oe-core/layers
cd ..
cp -r meta-aebox/ oe-core/layers/