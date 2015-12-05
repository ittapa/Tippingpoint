<%@ page contentType="text/html;charset=UTF-8"%> 

<script type="text/javascript">
   $(document).ready(function(){
   $('.carousel slide').css('width', $(window).width() - 50 );
   $('.carousel slide').css('height', $(window).height() - 50 );
   $(window).resize(function() {
        $('.carousel slide').css('width', $(window).width() - 50 );
        $('.carousel slide').css('height', $(window).height() - 50 );
   });
}); 
</script>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="1500">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="img/works/img11.jpg" alt="첫번째 사진">
      <div class="carousel-caption">
        ...
      </div>
    
    </div>
    <div class="item">
      <img src="img/works/img12.jpg" alt="두번째 사진">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    <div class="item">
      <img src="img/works/img13.jpg" alt="두번째 사진">
      <div class="carousel-caption">
        ...
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>