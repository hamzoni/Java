<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/froala_editor.min.js" ></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/align.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/code_beautifier.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/code_view.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/colors.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/draggable.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/emoticons.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/font_size.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/font_family.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/image.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/file.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/image_manager.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/line_breaker.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/link.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/lists.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/paragraph_format.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/paragraph_style.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/video.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/table.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/url.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/entities.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/char_counter.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/inline_style.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/save.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/plugins/fullscreen.min.js"></script>
<script type="text/javascript" src="${path}Assets/texteditor/js/languages/ro.js"></script>
<script>
    $(function () {
        $('#editor').froalaEditor({});
    });
    $('#editor').on('froalaEditor.keyup', function (e, editor, keyupEvent) {
        $('editor').val($('div#froala-editor').froalaEditor('html.get'));
    });
</script>