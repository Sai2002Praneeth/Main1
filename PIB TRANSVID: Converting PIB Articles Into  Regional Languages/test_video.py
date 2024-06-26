from moviepy.editor import VideoFileClip, TextClip, CompositeVideoClip
import textwrap

def wrap_text(text, width=30):
    return '\n'.join(textwrap.wrap(text, width))

def generate_subtitles(captions, font_size=30, lang='hi'):
    subtitle_clips = []
    for caption in captions:
        wrapped_text = wrap_text(caption)
        caption_clip = TextClip(wrapped_text, fontsize=font_size, color='white', bg_color='black', size=(640, 480), lang=lang)

        # Set initial position to the right (x=640)
        caption_clip = caption_clip.set_pos(('right', 'center'))

        # Check if the clip is not empty before appending
        if caption_clip.size != (0, 0):
            subtitle_clips.append(caption_clip)
    
    return subtitle_clips

def main(video_path, captions_file, output_path):
    # Load the video clip
    video_clip = VideoFileClip(video_path)

    # Read captions from file
    with open(captions_file, 'r', encoding='utf-8') as file:
        captions = [line.strip() for line in file.readlines()]

    # Generate subtitle clips
    subtitle_clips = generate_subtitles(captions, lang='hi')

    # Calculate the total duration of all non-empty subtitle clips
    total_duration = sum(clip.duration for clip in subtitle_clips if clip.duration is not None)

    # Create a subtitles clip with a scrolling effect
    subtitles_clip = CompositeVideoClip(subtitle_clips, size=(640, 480)).set_duration(total_duration)

    # Overlay subtitles on the video
    video_with_subtitles = CompositeVideoClip([video_clip, subtitles_clip.set_position(('center', 'bottom')).set_duration(video_clip.duration)])

    # Write the final video with subtitles
    video_with_subtitles.write_videofile(output_path, codec='libx264', audio_codec='aac')

if __name__ == "__main__":
    video_path = "F:/AlekhyaaBackend/assets/generated_video.mp4"
    captions_file = "F:/AlekhyaaBackend/assets/v.txt"
    output_path = "F:/AlekhyaaBackend/assets/video_with_subtitles.mp4"

    main(video_path, captions_file, output_path)
