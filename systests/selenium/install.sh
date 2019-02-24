#!/usr/bin/env bash

version="v0.24.0"
os="linux64"

wget "https://github.com/mozilla/geckodriver/releases/download/${version}/geckodriver-${version}-${os}.tar.gz" \
    && tar -xvzf "geckodriver-${version}-${os}.tar.gz" \
    && sudo chmod +x geckodriver \
    && sudo mv geckodriver /usr/local/bin/ \
    && rm "geckodriver-${version}-${os}.tar.gz"
