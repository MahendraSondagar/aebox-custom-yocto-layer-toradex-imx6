# Meta Aebox



## Getting started

```
git clone https://gitlab.com/smart-energy-management/meta-aebox.git
```


## First time

Execute the init.sh script

- This will create a oe-core folder
- Download yocto from Toradex (kirkstone branch)
- Download the poky layer (kirkstone branch)
- Download the meta-qt6 layer (6.6.3)
- Copy the meta-aebox layer to the **oe-core\layers\\** folder 

## Every time

When you open a terminal, first you need to **source** the environment

 - Run the following command in the root folder

 ```
 source oe-core/layers/poky/oe-init-build-env build
 ```

- You're now in the ..\meta-aebox\build\ folder
- Run **bitbake-layers show-layers**
- This should show something like this

```
NOTE: Starting bitbake server...
layer                 path                                      priority
==========================================================================
meta                  /home/guy/oe-core/layers/poky/meta        5
meta-poky             /home/guy/oe-core/layers/poky/meta-poky   5
meta-yocto-bsp        /home/guy/oe-core/layers/poky/meta-yocto-bsp  5
meta-oe               /home/guy/oe-core/layers/meta-openembedded/meta-oe  5
meta-python           /home/guy/oe-core/layers/meta-openembedded/meta-python  5
meta-networking       /home/guy/oe-core/layers/meta-openembedded/meta-networking  5
meta-freescale        /home/guy/oe-core/layers/meta-freescale   5
meta-toradex-bsp-common  /home/guy/oe-core/layers/meta-toradex-bsp-common  23
meta-freescale-3rdparty  /home/guy/oe-core/layers/meta-freescale-3rdparty  4
meta-toradex-nxp      /home/guy/oe-core/layers/meta-toradex-nxp  22
meta-aebox            /home/guy/oe-core/layers/meta-aebox       6
meta-qt6              /home/guy/oe-core/layers/meta-qt6         5
meta-toradex-distro   /home/guy/oe-core/layers/meta-toradex-distro  21
```

 - Run **bitbake custom-image-aebox** to start the build