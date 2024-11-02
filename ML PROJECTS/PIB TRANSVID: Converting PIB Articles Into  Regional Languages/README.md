# Project Name
PIB TRANSVID: Converting PIB Articles Into Regional Languages

# Installation

1) Set up TTS Environment:
      Start by setting up your Text-to-Speech (TTS) environment. This involves installing and configuring the TTS software or library you plan to use with gTTS. Once 
      you have TTS working, you can move on to integrating it with Streamlit. 
2) Set up Streamlit Web Interface:
      After configuring your TTS environment, set up your Streamlit web interface. Write your Streamlit application code (app.py, for example) and ensure it includes 
      functionality to interact with your TTS system, converting text inputs into spoken outputs.
3) Download and Install ImageMagick Display:
       Install and configure ImageMagick for image processing or display purposes within Streamlit app, you can do this last. ImageMagick installation typically 
       involves downloading the binaries or using package managers specific to your operating system.

# Workflow

1) Copying Link of PIB Article through PIB website.
2) Scraping: Copy link in streamlit web interface and scrape the press releases.
3) Cleaning: After scraping, clean the script so that only text in press article will be generated.
4) Text Summary: Text Summarization is done for cleaned script
5) Language selection and Text to speech conversion
6) Video Generation

