/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 var caja;
if (typeof exports === 'object') {

    var joint = {
        util: require('../src/core').util,
        shapes: {
            basic: require('./joint.shapes.basic')
        },
        dia: {
            ElementView: require('../src/joint.dia.element').ElementView,
            Link: require('../src/joint.dia.link').Link
        }
    };
    var _ = require('lodash');
}

joint.shapes.arbolEventos = {};

joint.shapes.arbolEventos.Model = joint.shapes.basic.Generic.extend(_.extend({}, joint.shapes.basic.PortsModelInterface, {

    markup: '<g class="rotatable"><g class="scalable"><rect class="body"/><image class="img" />  </g><text class="label"/><g class="inPorts"/><g class="outPorts"/></g>',
    portMarkup: '<g class="port port<%= id %>"><circle class="port-body"/></g>',

    defaults: joint.util.deepSupplement({

        type: 'arbolEventos.Model',
        size: { width: 1, height: 1 },
        
        inPorts: [],
        outPorts: [],

        attrs: {
            '.': { magnet: false },
            '.body': {
                width: 80, height: 80,
                stroke: '#000000'
            },
            '.port-body': {
                r: 10,
                magnet: true,
                stroke: '#000000'
            },
            text: {
                'pointer-events': 'none'
            },
            '.label': { text: 'Model', 'ref-x': .5, 'ref-y': 10, ref: '.body', 'text-anchor': 'middle', fill: '#000000' },
            '.inPorts .port-label': { x:37, dy: -5, 'text-anchor': 'end', fill: '#000000' },
            '.outPorts .port-label':{ x: 17, dy: -7, fill: '#000000' }
        }

    }, joint.shapes.basic.Generic.prototype.defaults),

    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -23; }
        
        

        return attrs;
    }
}));


joint.shapes.arbolEventos.Model.prototype.setIdModel=function(id){
    console.log("dentro del modelo");
    console.log(id.target);
    this.id=id;
//this.model.id=id;

};

    //Editado Ramon       
    joint.shapes.arbolEventos.EventoIniciador=joint.shapes.arbolEventos.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbolEventos.EventoIniciador',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbolEventos.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = 100; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 200; }       
       return attrs;
    }
    });
    
    joint.shapes.arbolEventos.Sistema=joint.shapes.arbolEventos.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbolEventos.Sistema',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbolEventos.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + .99) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = -20; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 100; }       
       return attrs;
    }
    });
    
    joint.shapes.arbolEventos.Frecuencia=joint.shapes.arbolEventos.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbolEventos.Frecuencia',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbolEventos.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + 0.3) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = -25; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 2   ; }       
       return attrs;
    }
    });
    
    joint.shapes.arbolEventos.Exito=joint.shapes.arbolEventos.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbolEventos.Exito',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbolEventos.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + -20) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = -20; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 2; }       
       return attrs;
    }
    });
    
    joint.shapes.arbolEventos.EventoIniciadorModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="eventoIniciador">',
        '<input class="name" id="txtValorEvento" name="valorEventoIniciador" type="text" size="9"  value="0" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name jaja",$(evt.target).val());
            //arboleventos.eventoIniciador.eventoIniciador.setValor(eventoIniciadorValor);
            //console.log(eventoIniciador);
            document.getElementById("txtValorEventoIniciador").value=$(evt.target).val();
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.eventoIniciador').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});
    
    joint.shapes.arbolEventos.SistemaModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="sistema">',
        '<input class="name" id="txtValorArbolFallas" name="valorArbol" type="text" size="9"  value="0" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
  
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.sistema').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
        if(typeof this.model.sistema !='undefined'){
                 console.log("En if:");
            this.$box.find('.name').val(this.model.sistema.getValorArbolFalla());
        }
     console.log("Actualizando sistema:");
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});

joint.shapes.arbolEventos.FrecuenciaModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="frecuencia">',
        '<input class="name" id="txtFrecuencia" name="valorFrecuencia" type="text" size="9"  value="0" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.frecuencia').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        if(typeof this.model.frecuencia !='undefined'){//////////////////////
                 console.log("En if:",this.model.frecuencia);
            this.$box.find('.name').val(this.model.frecuencia.toFixed(4));
        }
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});

joint.shapes.arbolEventos.ExitoModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="exito">',
        '<input class="name" id="txtValorExito" name="valorExito" type="text" size="9"  value="" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.exito').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
        if(typeof this.model.exito !='undefined'){//////////////////////
                 console.log("En if:",this.model.exito);
            this.$box.find('.name').val(this.model.exito.toFixed(4));
        }
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});
    
    //Termina editado Ramon
    
     // function capturaInputEvento(evento){
     //    var eventoValue=evento;
     //        alert(evento);
     //    }
     var valorEvento="";
     var valorCompuerta="";

joint.shapes.arbolEventos.ModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="evento">',
        '<button class="delete">x</button>',
        '<input class="name" name="nameEvento" type="text"  value="0" />',
        '<input class="value" name="valueEvento" type="text" size="5" value="0" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
       
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val(),this);
            valorEvento=$(evt.target).val();
            if(typeof this.model.Evento!='undefined'){
                console.log(this.model.Evento);                
                this.model.Evento.setValor(eval($(evt.target).val()));
                console.log(this.model.Evento);
                $(evt.target).val('');
            }
            
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.evento').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});


joint.shapes.arbolEventos.Link = joint.dia.Link.extend({

    defaults: {
    type: 'arbolEventos.Link',
    attrs: {
            '.label': { text: 'Model', 'ref-x': .4, 'ref-y': .2 },
            rect: { fill: '#2ECC71' },
            '.inPorts circle': { fill: '#16A085', magnet: 'passive', type: 'input' },
            '.outPorts circle': { fill: '#E74C3C', type: 'output' }
        }
    }
});


joint.shapes.arbolEventos.EventoIniciadorView=joint.shapes.arbolEventos.EventoIniciadorModelView;
joint.shapes.arbolEventos.EventoIniciadorView=joint.shapes.arbolEventos.EventoIniciadorModelView;
joint.shapes.arbolEventos.SistemaView=joint.shapes.arbolEventos.SistemaModelView;
joint.shapes.arbolEventos.FrecuenciaView=joint.shapes.arbolEventos.FrecuenciaModelView;
joint.shapes.arbolEventos.ExitoView=joint.shapes.arbolEventos.ExitoModelView;


if (typeof exports === 'object') {

    module.exports = joint.shapes.arbolEventos;
}


