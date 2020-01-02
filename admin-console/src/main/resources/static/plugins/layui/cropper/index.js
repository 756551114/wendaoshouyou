function CropperPackage(options) {
	var _default = {title:'图片裁减',okText:'确定',cancelText:'取消',wind:window};
	this.options = $.extend(true, {}, _default, options);
	
	this.template = 
	'<div class="cropper-modal-warpper fade" id="cropper_modal_template">'+
		'<div class="modal-dialog">'+
			'<div class="modal-content">'+
				'<div class="modal-header">'+
					'<h5 class="modal-title">'+this.options.title+'</h5>'+
					'<button type="button" class="close" data-dismiss="modal" aria-label="Close">'+
						'<span aria-hidden="true">×</span>'+
					'</button>'+
				'</div>'+
				'<div class="modal-body">'+
					'<div class="image-warpper">'+
						'<div class="img-container">'+
							'<img id="cropper_image" src="" alt="Picture" />'+
						'</div>'+
						'<div class="img-preview">'+
							'<div id="cropper_preview"></div>'+
						'</div>'+
					'</div>'+
				'</div>'+
				'<div class="modal-footer">'+
					'<button type="button" class="btn btn-secondary" data-dismiss="modal">'+this.options.cancelText+'</button>'+
					'<button type="button" class="btn btn-primary" id="cropper_ok">'+this.options.okText+'</button>'+
				'</div>'+
			'</div>'+
		'</div>'+
	'</div>';
	
	$(this.options.wind.document).on('click','#cropper_modal_template [data-dismiss=modal]', function(){
		var $template = $(this).parents('#cropper_modal_template');
		closeCropper($template);
	});
}



/**
 * @param {Object} options
 */
CropperPackage.prototype.coverImage = function(options) {
	var _default = {width:345,height:160};
	options = $.extend(true, {}, _default, options);
	var body = this.options.wind.document.body;
	
	// 显示文件
	var file = options.fileData;
	var fileUrl = URL.createObjectURL(file);
	
	// 预览宽高
	var previewWidth = options.width;
	var previewHeight = options.height;
	if (previewWidth > 345) {
		var rate = previewWidth / 345;
		previewWidth = 345;
		previewHeight = Math.round(previewHeight / rate);
	}
	console.log('宽度：' + options.width + '，高度：' + options.height + '，预览宽度：' + previewWidth + '，预览高度：' + previewHeight);
	
	$(body).append(this.template);
	var $image = $(body.querySelector('#cropper_image'));
	var $preview = $(body.querySelector('#cropper_preview'));
	var $template = $(body.querySelector('#cropper_modal_template'));
	
	$image.attr('src',fileUrl);
	$preview.css({width:previewWidth,height:previewWidth});
	
	// 显示modal
	$template.show(function(){
		$(this).addClass('show');
		
		// 初始化cropper
		$image.cropper({
			viewMode: 1,
			preview: $preview[0],
			aspectRatio: options.width / options.height,
			dragMode: 'move'
		});
		
		// 确认裁减
		$(body.querySelector('#cropper_ok')).click(function(){
			var canvas = $image.cropper('getCroppedCanvas',{width:options.width,height:options.height});
			canvas.toBlob(function(blob){
				// 创建文件对象
				var ext = blob.type.split('/')[1];
				var fileName = new Date().getTime() + '.' + ext;
				var imgFile = new File([blob], fileName, { type: blob.type });
				// 回调
				options.ok && options.ok(imgFile);
				// 销毁
				$image.cropper('destroy');
				closeCropper($template);
			});
		});
		
	});
	
}

function closeCropper($template) {
	$template.removeClass('show');
	setTimeout(function(){
		$template.remove();
	},200);
}