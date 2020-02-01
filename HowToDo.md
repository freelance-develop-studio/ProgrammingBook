# How to do

## Install pandoc convertor markdown to pdf
1. Install Pandoc in terminal by package manager (apt-get on Ubuntu or brew on MacOs)
```
install pandoc
```
2. Install Texts - Xelatex pdf engine from [web](http://www.texts.io).
3. Install recommended group of fonts for Xelatex in terminal.
```
sudo tlmgr install collection-fontsrecommended
```
4. Example convert markdown file to PDF.
```
pandoc UvodDoSvetaKryptomen.md --pdf-engine=xelatex -o UvodDoSvetaKryptomen.pdf
```
