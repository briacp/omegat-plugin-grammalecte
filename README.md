# OmegaT Plugin - Grammalecte

## Description

Grammalecte is an open-source grammatical checker for French. This plugin enables OmegaT to check the current segment with Grammalecte and can provide suggestions. It acts like LanguageTool but has a different approach which gives better results (in my opinion).

![screenshot](https://raw.githubusercontent.com/briacp/omegat-plugin-grammalecte/master/omegat-plugin-grammalecte.png)


Currently, this plugin requires a running Grammalecte server. The server can be downloaded on [Grammalecte website](https://grammalecte.net/grammalecte/zip/Grammalecte-fr-v1.5.0.zip). 

$ python3 grammalecte-server.py -p 8079 -t

## Running the Grammalecte server

Grammalecte requires Python v.3 to run. Once the `Grammalecte-fr-v1.5.0.zip` has been downloaded and extracted in its own directory, you can launch the server with the following command line (to run on port `8079`for example, the `-t` switch display the documentation of the server):

```bash
$ python3 grammalecte-server.py -p 8079 -t
```

If all goes well, the server should be running like this:

```bash
Python: 3.6.8 (default, Jan 14 2019, 11:02:34)
[GCC 8.0.1 20180414 (experimental) [trunk revision 259383]]
Grammalecte v1.5.0
Options:
apos:   False   Apostrophe typographique
   [...]
vmode:  True    Modes verbaux

CPU processes used for workers:  11
Bottle v0.12.13 server starting up (using WSGIRefServer())...
Listening on http://localhost:8079/
Hit Ctrl-C to quit.
```

In OmegaT, you will have to configure the server Url by appending `gc_text/fr` to the server Url. In this example, it should be `http://localhost:8079/gc_text/fr`.

## Installation

You can download the plugin jar file from the [release page](../../releases). The OmegaT plugin jar should be placed in `$HOME/.omegat/plugins` (Linux), `~/Library/Preferences/OmegaT/plugins/` (macOS), or `C:\Program Files\OmegaT\plugins` (Windows) depending on your operating system.


## License

This project is distributed under the GNU general public license version 3 or later.
